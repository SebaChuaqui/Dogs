package ui

import MyViewModel.ViewModel
import adapters.BavausAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bavaus.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(), BavausAdapter.Bavaus {

    lateinit var mViewModel : ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) //activar menu item
        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView           = recyclerView
        val mAdapter                = BavausAdapter(this)
        mRecyclerView.adapter       = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        mViewModel.mAllBavaus.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListBavaus(it)

        })
    }

    fun passBavau(mBavau: String) {
        val mBundle = Bundle()
        mBundle.putString("bavau", mBavau)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,mBundle)
    }

    override fun passBavaus(mBavaus: String) {
        Log.d("funciona o no", mBavaus)
    }
}