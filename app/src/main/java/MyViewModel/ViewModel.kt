package MyViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import model.BavausDB
import model.DataBavausDBList
import model.DataImagesBavausDBList
import model.RepositoryBavaus
import retrofit.DataBavausList

class ViewModel (application: Application): AndroidViewModel(application){

    private val mBavausRepository : RepositoryBavaus
    val mAllBavaus : LiveData<List<DataBavausDBList>>
    val mAllImagesBavaus : LiveData<List<DataImagesBavausDBList>>



    init {
        val mBavausDAO = BavausDB.getDataBase(application).getBavausDAO()
        val mImagesBavausDAO = BavausDB.getDataBase(application).getImagesDAO()
        mBavausRepository = RepositoryBavaus(mBavausDAO,mImagesBavausDAO)
        mAllBavaus= mBavausRepository.mLiveDataBreedList
        mAllImagesBavaus = mBavausRepository.mLiveDataImageBreedList
        mBavausRepository.getBavausFromServer()
    }


    fun getImages(mRaza : String) {
        mBavausRepository.getImageBreedsFromServer(mRaza)
        Log.d(" fragment viewModel =","Paso por Images")
    }

}