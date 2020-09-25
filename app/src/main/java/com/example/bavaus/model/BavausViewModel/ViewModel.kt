package com.example.bavaus.model.BavausViewModel

import DataBase.BavausDataBase
import DataBase.BreedListBavau
import DataBase.ImagesBreedBavau
import MyRepository.RepositoryBavaus
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ViewModel(application: Application): AndroidViewModel(application) {

    private val mRepositoryBavaus : RepositoryBavaus
    val mAllListBavaus : LiveData<List<BreedListBavau>>
    val mAllImagesBavaus : LiveData<List<ImagesBreedBavau>>

    init{

        val mBavausDao = BavausDataBase.getDatabase(application).getBavausDao()
        val mBavausImagesDao = BavausDataBase.getDatabase(application).getBavausImagesDao()
        mRepositoryBavaus = RepositoryBavaus(mBavausDao, mBavausImagesDao)
        mAllListBavaus = mRepositoryBavaus.mLiveDataBreedListBavau
        mAllImagesBavaus = mRepositoryBavaus.mLiveDataImageBreedBavau
        mRepositoryBavaus.getBreedsBavausFromServer()
        mRepositoryBavaus.getImagesBavausBreedsFromServer("")
    }

    fun getBavausImages(mRaza: String){
        mRepositoryBavaus.getImagesBavausBreedsFromServer(mRaza)
        Log.d("Fragment Bavaus =", "muestra images")
    }

}