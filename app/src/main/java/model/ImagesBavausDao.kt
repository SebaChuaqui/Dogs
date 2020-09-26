package model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ImagesBavausDao {



        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllImages(mImagesList: List<DataImagesBavausDBList>)

        @Query("SELECT * FROM images_table")
        fun getAllImagesFromDB(): LiveData<List<DataImagesBavausDBList>>

    }
