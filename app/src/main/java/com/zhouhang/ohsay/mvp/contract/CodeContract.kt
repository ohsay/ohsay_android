package com.zhouhang.ohsay.mvp.contract

import com.zhouhang.ohsay.base.IBaseView
import com.zhouhang.ohsay.base.IPresenter


interface CodeContract {
    interface View : IBaseView {

        fun setCode()

        fun showError(msg: String, errorCode: Int)
    }

    interface Presenter : IPresenter<View> {

        fun requestCode(mobile: String, type: String)
    }
}