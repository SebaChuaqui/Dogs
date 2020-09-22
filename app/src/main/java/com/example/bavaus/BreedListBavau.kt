package com.example.bavaus


import com.google.gson.annotations.SerializedName

data class BreedListBavau(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)