package dev.arj.noidea.data.repo.movie

import dev.arj.noidea.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val apiService: ApiService) {

  suspend fun getMovie(): Flow<MovieResponse> {
    return flow {
      emit(apiService.getMovies())
    }.flowOn(Dispatchers.IO)
  }

}