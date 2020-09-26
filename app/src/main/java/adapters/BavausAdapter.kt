package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bavaus.R
import kotlinx.android.synthetic.main.fragment_second.view.*
import model.DataBavausDBList
import retrofit.DataBavausList

class BavausAdapter(var mPassBavaus: Bavaus) : RecyclerView.Adapter<BavausAdapter.TaskViewHolder>() {

    private var dataList = emptyList<DataBavausDBList>()

    fun updateListBavaus (mDataList: List<DataBavausDBList>){
        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val breedsName = itemView.tv_bavaus
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mPassBavaus.passBavaus(dataList[adapterPosition].bavaus)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bavaus,parent,false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val mBavau = dataList[position]
        holder.breedsName.text = mBavau.bavaus

    }

    override fun getItemCount() = dataList.size

    interface Bavaus{
        fun passBavaus(mBavaus: String)
    }

}