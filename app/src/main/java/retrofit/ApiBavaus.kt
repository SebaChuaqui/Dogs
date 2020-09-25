package retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiBavaus {

    @GET("breeds/list")
    fun getDataListFromBavaus() : Call<Bavausjson>


    @GET("breed/{razas}/images")
    fun getDataImagesFromBavaus(@Path("razas") mRazas: String) : Call<Bavausjson>

}