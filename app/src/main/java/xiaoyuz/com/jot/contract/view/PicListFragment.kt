package xiaoyuz.com.jot.contract.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_pic_list.*
import xiaoyuz.com.jot.R
import xiaoyuz.com.jot.contract.PicListContract
import xiaoyuz.com.jot.contract.presenter.PicListPresenter
import xiaoyuz.com.jot.ui.adapter.PicListAdapter
import java.io.File

class PicListFragment : Fragment(), PicListContract.View {

    private var mPicNames: MutableList<String> = mutableListOf()
    private lateinit var mFolderName: String

    override var presenter: PicListContract.Presenter
        get() = PicListPresenter(this)
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.content_pic_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mFolderName = arguments.getString("folderName")
        fileList.layoutManager = LinearLayoutManager(context)
        fileList.adapter = PicListAdapter(mPicNames, presenter)
        presenter.loadPics(mFolderName)
    }

    override fun showPics(pics: List<File>) {
        mPicNames.clear()
        mPicNames.addAll(pics.map { it.name })
        fileList.adapter.notifyDataSetChanged()
    }
}