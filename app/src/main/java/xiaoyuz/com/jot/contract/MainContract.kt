package xiaoyuz.com.jot.contract

import xiaoyuz.com.jot.base.BasePresenter
import xiaoyuz.com.jot.base.BaseView

interface MainContract {

    interface View: BaseView<Presenter> {
        fun show(num: Int)
    }

    interface Presenter: BasePresenter {
        fun load(num: Int)
    }
}