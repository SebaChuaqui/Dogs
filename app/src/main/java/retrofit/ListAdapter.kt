package retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bavaus.R
import kotlinx.android.synthetic.main.bavaus.view.*

class ListAdapter(var mPassList: ListBavaus ): RecyclerView.Adapter<ListAdapter.BavausViewHolder>() {

    private var dataList = emptyList<BreedListBavau>()

    fun updateListBavaus (mDataList: List<BreedListBavau>){
        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class BavausViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val bavausName = itemView.tvBavaus
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mPassList.passListBavaus(dataList[adapterPosition].mBavausList)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BavausViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bavaus,parent,false)
        return BavausViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BavausViewHolder, position: Int) {
        val mBreeds = dataList[position]
        holder.bavausName.text = mBreeds.mBavausList

    }

    override fun getItemCount() = dataList.size

    interface ListBavaus{
        fun passListBavaus(mBavaus: String)
    }
}