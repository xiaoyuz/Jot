package xiaoyuz.com.jot.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.pic_item.view.*
import xiaoyuz.com.jot.R
import xiaoyuz.com.jot.contract.PicListContract

private const val FILE_TYPE = 1
private const val ADD_TYPE = 2

class PicListAdapter(private val mPicList: List<String>,
                     private val mPresenter: PicListContract.Presenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FolderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener{  }
        }
    }

    inner class AddViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType) {
        FILE_TYPE -> FolderViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.pic_item, parent, false))
        else -> AddViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.add_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FolderViewHolder) {
            holder.itemView.pic.text = mPicList[position]
        }
    }

    override fun getItemViewType(position: Int)
            = if (position == mPicList.size) ADD_TYPE else FILE_TYPE

    override fun getItemCount() = mPicList.size + 1
}