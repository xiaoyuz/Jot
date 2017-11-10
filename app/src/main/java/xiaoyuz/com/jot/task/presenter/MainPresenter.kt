package xiaoyuz.com.jot.task.presenter

import xiaoyuz.com.jot.task.MainContract

class MainPresenter(private val mView: MainContract.View): MainContract.Presenter {

    override fun start() {

    }

    override fun load(num: Int) {
        mView.show(num)
    }
}