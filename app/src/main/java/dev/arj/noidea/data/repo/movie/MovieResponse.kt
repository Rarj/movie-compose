package dev.arj.noidea.data.repo.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
  val results: List<MovieItem>
)

data class MovieItem(
        val id: Int,
        val title: String,
        @SerializedName("poster_path")
        val posterPath: String?
)
