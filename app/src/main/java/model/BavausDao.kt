package model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import retrofit.DataBavausList

@Dao
interface BavausDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAllBavaus(mBavausList: List<DataBavausDBList>)

        @Query("SELECT * FROM bavaus_table")
        fun getAllBavausFromDB(): LiveData<List<DataBavausDBList>>

    }
