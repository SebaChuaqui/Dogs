package DataBase


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bavaus_table")
data class BreedListBavau(@PrimaryKey val mBavausList: String) {

}