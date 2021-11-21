package dev.arj.noidea.feature.movie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import dev.arj.noidea.Network.BASE_URL_IMAGE
import dev.arj.noidea.R
import dev.arj.noidea.data.repo.movie.MovieItem

interface MovieListener {
  fun showDetail(id: Int)
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MovieCompose(private val listener: MovieListener) {

  @Composable
  fun MovieList(movieList: List<MovieItem>) {
    LazyVerticalGrid(
          cells = GridCells.Fixed(2),
          modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
    ) {
      items(movieList) { item ->
        Card(
              onClick = { listener.showDetail(item.id) },
              modifier = Modifier
                    .height(350.dp)
                    .padding(10.dp),
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
              .height(height = 275.dp)
              .constrainAs(poster) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(title.top)
              },
        painter = rememberImagePainter(
              data = "${BASE_URL_IMAGE}${movieItem.posterPath}",
              builder = {
                placeholder(R.drawable.ic_placeholder)
              }
        ),
        contentDescription = "Movie Poster",
            contentScale = ContentScale.FillBounds
      )

      Text(
            text = movieItem.title,
            modifier = Modifier
                  .padding(20.dp)
                  .constrainAs(title) {
                    top.linkTo(poster.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                  },
            style = TextStyle(
                  fontSize = 16.sp,
                  color = Color.Black,
                  textAlign = TextAlign.Center
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
      )

    }
  }

}