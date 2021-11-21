package dev.arj.noidea.feature.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.arj.noidea.Network
import dev.arj.noidea.data.repo.movie.MovieItem
import dev.arj.noidea.data.repo.movie.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

  private val apiService = Network.getService()
  private val repo = MovieRepository(apiService)

  var movies: List<MovieItem> by mutableStateOf(emptyList())

  init {
    getMovie()
  }

  private fun getMovie() {
    viewModelScope.launch {
      repo.getMovie().collect {
        movies = it.results
      }
    }
  }
}