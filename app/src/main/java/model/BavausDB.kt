package model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME="bavaus_db"

@Database(entities = [DataBavausDBList::class,DataImagesBavausDBList::class],version = 1)

abstract class BavausDB : RoomDatabase() {

    abstract fun getBavausDAO(): BavausDao
    abstract fun getImagesDAO(): ImagesBavausDao

    companion object {
        @Volatile
        private var INSTANCE: BavausDB? = null

        fun getDataBase(context: Context): BavausDB {

            val tempInterface = INSTANCE
            if(tempInterface !=null) {
                return tempInterface
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    BavausDB::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}