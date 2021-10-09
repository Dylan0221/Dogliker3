package com.example.dogliker3.model

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message")
    val image: String,
    @SerializedName("status")
    val status: String
)
