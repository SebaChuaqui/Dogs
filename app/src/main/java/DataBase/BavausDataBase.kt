package DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "bavaus_db"

@Database(entities = [BreedListBavau::class, ImagesBreedBavau::class], version = 1)

abstract class BavausDataBase : RoomDatabase(){

    abstract fun getBavausDao(): BavausDao
    abstract fun getBavausImagesDao(): BavausImagesDao

    companion object{

        @Volatile
        private var INSTANCE: BavausDataBase? = null

        fun getDatabase(context: Context) : BavausDataBase {

            val bavausInstance = INSTANCE
            if(bavausInstance != null){
                return bavausInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context,
                    BavausDataBase::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}