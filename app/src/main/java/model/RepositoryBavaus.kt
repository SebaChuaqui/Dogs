package model

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit.DataBavausList
import retrofit.DataImagesBavausList
import retrofit.RetrofitBavaus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryBavaus (private val mBavausDAO: BavausDao, private val mImagesBavausDAO: ImagesBavausDao){
    private val service = RetrofitBavaus.getRetrofitClient()

    val mLiveDataBreedList = mBavausDAO.getAllBavausFromDB()
    val mLiveDataImageBreedList = mImagesBavausDAO.getAllImagesFromDB()

    val mDataBavausDBList =  mutableListOf<DataBavausDBList>()
    val mDataImagesBavausDBList = mutableListOf<DataImagesBavausDBList>()


    fun getBavausFromServer() {
        val mCall = service.getBavausFromApi()
        mCall.enqueue(object : Callback<DataBavausList> {
            override fun onResponse(call: Call<DataBavausList>, response: Response<DataBavausList>) {
                when(response.code()){

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            mBavausDAO.insertAllBavaus(transformation(it.message))
                        }
                    }
                    in 300..399 -> Log.d("ERROR 300 Breeds", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<DataBavausList>, t: Throwable) {

            }

        })
    }

  
    fun getImageBreedsFromServer(mRazas:String) {
        val mCall = service.getImagesBavausFromApi(mRazas)
        mCall.enqueue(object : Callback<DataImagesBavausList>{
            override fun onResponse(call: Call<DataImagesBavausList>, response: Response<DataImagesBavausList>) {
                when(response.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            mImagesBavausDAO.insertAllImages(transformationImages(mRazas,it.message))
                            Log.d("Arroz Repository =","Entro a la vieja 2 con $mRazas")
                        }

                    }

                    in 300..399 -> Log.d("ERROR 300 Images", response.errorBody().toString())
                }

            }

            override fun onFailure(call: Call<DataImagesBavausList>, t: Throwable) {
                Log.e("Repository Images", t.message.toString())
            }

        })
    }

    fun transformation(mStringList:List<String>):List<DataBavausDBList>{

        mStringList.map{
            mDataBavausDBList.add(DataBavausDBList(it))
        }
        return mDataBavausDBList
    }

    fun transformationImages(mRaza:String,mStringList:List<String>): MutableList<DataImagesBavausDBList> {

        mStringList.map{
            mDataImagesBavausDBList.add(DataImagesBavausDBList(bavaus = mRaza, imageUrl =it, status = false))
        }
        return mDataImagesBavausDBList
    }


}