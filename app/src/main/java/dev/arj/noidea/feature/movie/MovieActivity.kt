package dev.arj.noidea.feature.movie

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.arj.noidea.data.repo.movie.MovieItem
import dev.arj.noidea.ui.theme.NoIdeaTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MovieActivity : ComponentActivity(), MovieListener {
  private val movieViewModel: MovieViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NoIdeaTheme {
        Surface(color = MaterialTheme.colors.background) {
          MovieCompose(this).MovieList(movieList = movieViewModel.movies)
        }
      }
    }
  }

  override fun showDetail(id: Int) {
    Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
  }

  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
    NoIdeaTheme {
      Surface(color = MaterialTheme.colors.background) {
        MovieCompose(this).MovieList(
          movieList = listOf(
            MovieItem(1, "Batman", ""),
            MovieItem(1, "Batmanasdasdaddsnasknajkddddddddddddddddddddddddddddddddddsa", ""),
            MovieItem(1, "Batman", ""),
            MovieItem(1, "Baasndkaskasjndatman", ""),
            MovieItem(1, "Batman", "")
          )
        )
      }
    }
  }
}