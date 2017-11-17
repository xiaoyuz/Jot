package xiaoyuz.com.jot.contract.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.alert
import xiaoyuz.com.jot.R
import xiaoyuz.com.jot.contract.MainContract
import xiaoyuz.com.jot.contract.presenter.MainPresenter
import xiaoyuz.com.jot.contract.presenter.PicListPresenter
import xiaoyuz.com.jot.ui.adapter.FolderAdapter
import xiaoyuz.com.jot.util.*
import java.io.File

class MainFragment : Fragment(), MainContract.View {

    private var mFolderNames: MutableList<String> = mutableListOf()

    override var presenter: MainContract.Presenter
        get() = MainPresenter(this)
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.content_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        folderList.layoutManager = LinearLayoutManager(context)
        folderList.adapter = FolderAdapter(mFolderNames, presenter)
        presenter.loadFolders()
    }

    override fun showFolders(folders: List<File>) {
        mFolderNames.clear()
        mFolderNames.addAll(folders.map { it.name })
        folderList.adapter.notifyDataSetChanged()
    }

    override fun showCreateFolderDialog() {
        context.alert(message = R.string.create_folder_title, init = {
            val editText = EditText(context)
            customView(editText)
            cancellable(true)
            positiveButton {
                createFolder(editText.text.toString())
                presenter.loadFolders()
            }
        }).show()
    }

    override fun openFolder(folderName: String) {
        val pics = listFiles(folderName)
        val picListFragment = PicListFragment()
        picListFragment.arguments = Bundle().apply { putString("folderName", folderName) }
        (activity as AppCompatActivity).addFragment(picListFragment)
        PicListPresenter(picListFragment)
    }
}