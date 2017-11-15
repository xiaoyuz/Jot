package xiaoyuz.com.jot.contract.presenter

import xiaoyuz.com.jot.contract.MainContract
import xiaoyuz.com.jot.util.listFolders

class MainPresenter(private val mView: MainContract.View): MainContract.Presenter {

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun loadFolders() {
        mView.showFolders(listFolders())
    }

    override fun createFolder() {
        mView.showCreateFolderDialog()
    }

    override fun folderCreated(name: String) {

    }
}