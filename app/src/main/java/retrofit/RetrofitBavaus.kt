package retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBavaus {

    companion object{

        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitBavaus(): ApiBavaus {
            val mRetrofitBavaus = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofitBavaus.create(ApiBavaus::class.java)
        }
    }
}