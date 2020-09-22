package com.example.bavaus


import com.google.gson.annotations.SerializedName

data class ImagesBreedBavau(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)