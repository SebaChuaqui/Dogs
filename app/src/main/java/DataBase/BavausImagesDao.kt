package DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BavausImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBavausImages(mImagesBreedBavau: List<ImagesBreedBavau>)

    @Query("SELECT * FROM bavaus_images_table ")
    fun getAllBavausImagesFromDB(): LiveData<List<ImagesBreedBavau>>
}