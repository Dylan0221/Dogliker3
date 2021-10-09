package com.example.dogliker3.data.api

import com.example.dogliker3.model.DogResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("image/random")
    suspend fun getDog(): Response<DogResponse>
}