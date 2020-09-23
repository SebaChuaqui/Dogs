package com.example.bavaus.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bavaus_images_table")
data class ImagesBreedBavau(
    @PrimaryKey val id: String,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)