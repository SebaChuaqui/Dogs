package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bavaus.R
import model.DataImagesBavausDBList

class ImagesAdapter(): RecyclerView.Adapter<ImagesAdapter.TaskViewHolder>() {

    private var dataList = emptyList<DataImagesBavausDBList>()

    fun updateListBreedsImages (mDataList: List<DataImagesBavausDBList>){
        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class TaskViewHolder (itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val mImageUrl = itemView
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            // mPassData.passData(dataList[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.images,parent,false)
        return TaskViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        val mImagesDBList:DataImagesBavausDBList = dataList[position]
        Glide.with(holder.itemView.context).load(mImagesDBList.imageUrl).into(holder.mImageUrl as ImageView)

    }

    override fun getItemCount() = dataList.size

    interface ImagesBavaus{
        fun passBavaus (mImagesBavaus: DataImagesBavausDBList)
    }
}