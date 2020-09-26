package model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity (tableName = "bavaus_table")
data class DataBavausDBList(

    @PrimaryKey val bavaus:String
)