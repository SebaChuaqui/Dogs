package com.example.bavaus.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bavaus_table")
data class BreedListBavau(
    @PrimaryKey val id: String,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)