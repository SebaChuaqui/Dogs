package MyRepository

import DataBase.BavausDao
import DataBase.BavausImagesDao
import DataBase.BreedListBavau
import DataBase.ImagesBreedBavau
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit.Bavausjson
import retrofit.RetrofitBavaus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryBavaus (private val mBavausDao: BavausDao, private val mBavausImagesDao: BavausImagesDao){
    private val service = RetrofitBavaus.getRetrofitBavaus()

    val mLiveDataBreedListBavau = mBavausDao.getAllBavausFromDB()
    val mLiveDataImageBreedBavau = mBavausImagesDao.getAllBavausImagesFromDB()

    val mDataBreedsDBList =  mutableListOf<BreedListBavau>()
    val mDataImagesDBList = mutableListOf<ImagesBreedBavau>()

    //LaVieja1
    fun getBreedsBavausFromServer() {
        val mCall = service.getDataListFromBavaus()
        mCall.enqueue(object : Callback<Bavausjson>{
            override fun onResponse(call: Call<Bavausjson>, response: Response<Bavausjson>) {
                when(response.code()){

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            mBavausDao.insertAllBavaus(bavausList(it.message))
                        }
                    }
                    in 300..399 -> Log.d("ERROR 300 List Bavaus", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<Bavausjson>, t: Throwable) {
                Log.e("Error en API Bavaus", t.message.toString())
            }

        })
    }

    //LaVieja2
    fun getImagesBavausBreedsFromServer(mRazas:String) {

        val mCall = service.getDataImagesFromBavaus(mRazas)
        mCall.enqueue(object : Callback<Bavausjson>{
            override fun onResponse(call: Call<Bavausjson>, response: Response<Bavausjson>) {
                when(response.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            mBavausImagesDao.insertAllBavausImages(bavausImages(mRazas,it.message))

                        }

                    }

                    in 300..399 -> Log.d("ERROR 300 Images", response.errorBody().toString())
                }

            }

            override fun onFailure(call: Call<Bavausjson>, t: Throwable) {
                Log.e("Repository Images", t.message.toString())
            }

        })
    }

    fun bavausList(mStringList: List<String>):List<BreedListBavau>{

        mStringList.map{
            mDataBreedsDBList.add(BreedListBavau(it))
        }
        return mDataBreedsDBList
    }

    fun bavausImages(mRaza:String,mStringList:List<String>):List<ImagesBreedBavau>{

        mStringList.map{
            mDataImagesDBList.add(ImagesBreedBavau(dog = mRaza, imageUrl =it, status = false))
        }
        return mDataImagesDBList
    }


}


