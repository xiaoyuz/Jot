package xiaoyuz.com.jot.contract

import xiaoyuz.com.jot.base.BasePresenter
import xiaoyuz.com.jot.base.BaseView
import java.io.File

interface PicListContract {

    interface View: BaseView<Presenter> {
        fun showPics(pics: List<File>)
    }

    interface Presenter: BasePresenter {
        fun loadPics(folderName: String)

        fun createPic()
    }
}