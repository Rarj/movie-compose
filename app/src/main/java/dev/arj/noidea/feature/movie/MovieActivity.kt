package dev.arj.noidea.feature.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.arj.noidea.ui.theme.NoIdeaTheme

class MovieActivity : ComponentActivity() {
  private val movieViewModel: MovieViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NoIdeaTheme {
        Surface(color = MaterialTheme.colors.background) {
          MovieCompose().MovieList(movieList = movieViewModel.movies)
        }
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
    NoIdeaTheme {
      Surface(color = MaterialTheme.colors.background) {
        MovieCompose().MovieList(
          movieList = listOf(
            MovieItem("Batman", ""),
            MovieItem("Batman", ""),
            MovieItem("Batman", ""),
            MovieItem("Batman", ""),
            MovieItem("Batman", "")
          )
        )
      }
    }
  }
}