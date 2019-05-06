package com.zhouhang.ohsay.ui.activity

import com.zhouhang.ohsay.R
import com.zhouhang.ohsay.base.BaseActivity
import com.zhouhang.ohsay.mvp.contract.CodeContract
import com.zhouhang.ohsay.mvp.presenter.CodePresenter

class MainActivity : BaseActivity(), CodeContract.View {
    override fun setCode() {

    }

    override fun showError(msg: String, errorCode: Int) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    private val presenter by lazy { CodePresenter() }

    override fun initView() {
        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun initEvent() {
        presenter.requestCode("123123", "1")
    }

    override fun start() {
    }
}