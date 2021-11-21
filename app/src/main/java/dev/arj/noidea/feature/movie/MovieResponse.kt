package dev.arj.noidea.feature.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
  val results: List<MovieItem>
)

data class MovieItem(
  val title: String,
  @SerializedName("backdrop_path")
  val backdropPath: String?
)
