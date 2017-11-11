package xiaoyuz.com.jot.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.folder_item.view.*
import xiaoyuz.com.jot.R

private const val FOLDER_TYPE = 1
private const val ADD_TYPE = 2

class FolderAdapter(private val mFolderList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class FolderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener{  }
        }
    }

    class AddViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener{  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType) {
        FOLDER_TYPE -> FolderViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.folder_item, parent, false))
        else -> AddViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.add_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FolderViewHolder) {
            holder.itemView.folder.text = mFolderList[position]
        }
    }

    override fun getItemViewType(position: Int)
            = if (position == mFolderList.size) ADD_TYPE else FOLDER_TYPE

    override fun getItemCount() = mFolderList.size + 1
}