package DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BavausDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBavaus(mBavausList: List<BreedListBavau>)

    @Query("SELECT * FROM bavaus_table")
    fun getAllBavausFromDB(): LiveData<List<BreedListBavau>>


}