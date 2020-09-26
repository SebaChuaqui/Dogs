package model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images_table")
    data class DataImagesBavausDBList (
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id:Int=0,
        val bavaus:String,
        val imageUrl:String,
        val status: Boolean
    )
