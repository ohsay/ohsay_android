package com.zhouhang.ohsay.mvp.presenter

import com.zhouhang.ohsay.base.BasePresenter
import com.zhouhang.ohsay.mvp.contract.CodeContract
import com.zhouhang.ohsay.mvp.model.CodeModel
import com.zhouhang.ohsay.net.exception.ExceptionHandle


class CodePresenter : BasePresenter<CodeContract.View>(), CodeContract.Presenter {

    private val model: CodeModel by lazy {
        CodeModel()
    }

    override fun requestCode(mobile: String, type: String) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = model.requestCode(mobile, type)
            .subscribe({ bean ->
                mRootView?.apply {
                    mRootView?.dismissLoading()
                    when {
                        bean.code == 0 -> {
                        }
                        else -> showError(bean.message, bean.code)
                    }
                }
            }, { t ->
                mRootView?.apply {
                    mRootView?.dismissLoading()
                    showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                }
            })
        addSubscription(disposable)
    }
}