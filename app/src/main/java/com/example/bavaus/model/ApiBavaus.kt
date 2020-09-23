package com.example.bavaus.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiBavaus {

    @GET("breeds/list")
    fun getDataFromBavaus() : Call<List<BreedListBavau>>


    @GET("breed/{razas}/images")
    suspend fun getDataFromBavaus2(@Path("razas") mRazas: String) : Response<List<BreedListBavau>>

}