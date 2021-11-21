package dev.arj.noidea

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

  const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w342"
  private const val BASE_URL = "https://api.themoviedb.org/3/"

  private fun retrofitInstance() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  fun getService(): ApiService = retrofitInstance().create(ApiService::class.java)

}