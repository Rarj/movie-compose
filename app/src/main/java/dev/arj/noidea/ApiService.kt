package dev.arj.noidea

import dev.arj.noidea.data.repo.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("movie/popular")
  suspend fun getMovies(
    @Query("api_key") apiKey: String = "33ef4526082667e26fd77c6773694d55"
  ): MovieResponse

}
