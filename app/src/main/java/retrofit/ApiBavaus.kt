package retrofit

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiBavaus {

    @GET("breeds/list") //endPoint
    fun getBavausFromApi() : retrofit2.Call<DataBavausList>

    @GET("breed/{razas}/images") //endPoint
    fun getImagesBavausFromApi(@Path("razas") mRazas:String): retrofit2.Call<DataImagesBavausList>
}