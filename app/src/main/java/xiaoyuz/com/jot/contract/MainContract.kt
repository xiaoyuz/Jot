package xiaoyuz.com.jot.contract

import xiaoyuz.com.jot.base.BasePresenter
import xiaoyuz.com.jot.base.BaseView
import java.io.File

interface MainContract {

    interface View: BaseView<Presenter> {
        fun showFolders(folders: List<File>)

        fun showCreateFolderDialog()

        fun openFolder(folderName: String)
    }

    interface Presenter: BasePresenter {
        fun loadFolders()

        fun createFolder()

        fun folderCreated(name: String)

        fun openFolder(folderName: String)
    }
}