package xiaoyuz.com.jot.contract.presenter

import xiaoyuz.com.jot.contract.PicListContract
import xiaoyuz.com.jot.util.listFiles

class PicListPresenter(private val mView: PicListContract.View): PicListContract.Presenter {

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun loadPics(folderName: String) {
        mView.showPics(listFiles(folderName))
    }

    override fun createPic() {

    }
}