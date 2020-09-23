package com.example.bavaus.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BavausDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBavaus(mBavausList: List<BreedListBavau>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBavausImages(mImagesBreedBavau: List<ImagesBreedBavau>)


    @Query("SELECT * FROM bavaus_table")
    fun getAllBavausFromDB(): LiveData<List<BreedListBavau>>

    @Query("SELECT * FROM bavaus_table Where id =:mId" )
    fun obtainDataBavausFromDataBase(mId: String): LiveData<BreedListBavau>

    @Query("SELECT * FROM bavaus_images_table ")
    fun getAllBavausImagesFromDB(): LiveData<List<ImagesBreedBavau>>

    @Query("SELECT * FROM bavaus_images_table Where id =:mId ")
    fun obtainDataBavausImagesFromDataBase(mId: String): LiveData<ImagesBreedBavau>

}