package retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBavaus {


        companion object{
            private const val  URL_BASE = "https://dog.ceo/api/"

            fun getRetrofitClient() : ApiBavaus {
                val mRetrofitClient = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return mRetrofitClient.create(ApiBavaus::class.java)
            }

        }

    }