package dev.arj.noidea.feature.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import dev.arj.noidea.Network.BASE_URL_IMAGE
import dev.arj.noidea.R

class MovieCompose {

  @Composable
  fun MovieList(movieList: List<MovieItem>) {
    LazyColumn(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
      items(movieList) { item ->
        Card(
          modifier = Modifier.padding(10.dp),
          shape = RoundedCornerShape(20.dp)
        ) {
          BindMovieItem(movieItem = item)
        }
      }
    }
  }

  @Composable
  fun BindMovieItem(movieItem: MovieItem) {
    ConstraintLayout(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
      val (poster, title) = createRefs()

      Image(
        modifier = Modifier
          .fillMaxWidth()
          .height(height = 200.dp)
          .constrainAs(poster) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
          },
        painter = rememberImagePainter(
          data = "${BASE_URL_IMAGE}${movieItem.backdropPath}",
          builder = {
            placeholder(R.drawable.ic_placeholder)
          }
        ),
        contentDescription = "Movie Poster",
        contentScale = ContentScale.FillWidth
      )

      Text(
        text = movieItem.title,
        modifier = Modifier
          .padding(20.dp)
          .constrainAs(title) {
            top.linkTo(poster.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
          },
        style = TextStyle(fontSize = 16.sp)
      )

    }
  }

}