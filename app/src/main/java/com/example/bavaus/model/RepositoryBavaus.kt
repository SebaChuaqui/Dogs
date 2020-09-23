package com.example.bavaus.model

class RepositoryBavaus(private val bavausDao: BavausDao) {

    private val service = RetrofitBavaus.getRetrofitBavaus()
    val mLiveDataBreedListBavau = bavausDao.getAllBavausFromDB()
    val mLiveDataImagesBreedBavau = bavausDao.getAllBavausImagesFromDB()
    

}