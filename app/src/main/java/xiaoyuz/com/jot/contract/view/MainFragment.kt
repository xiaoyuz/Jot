package xiaoyuz.com.jot.contract.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast
import xiaoyuz.com.jot.R
import xiaoyuz.com.jot.contract.MainContract
import xiaoyuz.com.jot.contract.presenter.MainPresenter
import xiaoyuz.com.jot.ui.adapter.FolderAdapter

class MainFragment : Fragment(), MainContract.View {

    override var presenter: MainContract.Presenter
        get() = MainPresenter(this)
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.content_main, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fileList.layoutManager = LinearLayoutManager(context)
        fileList.adapter = FolderAdapter(listOf("TestFolder"))
    }

    override fun show(num: Int) {
        context.toast(num.toString())
    }
}