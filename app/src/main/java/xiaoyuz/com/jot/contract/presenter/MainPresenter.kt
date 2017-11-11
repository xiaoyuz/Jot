package xiaoyuz.com.jot.contract.presenter

import xiaoyuz.com.jot.contract.MainContract

class MainPresenter(private val mView: MainContract.View): MainContract.Presenter {

    override fun start() {

    }

    override fun load(num: Int) {
        mView.show(num)
    }
}