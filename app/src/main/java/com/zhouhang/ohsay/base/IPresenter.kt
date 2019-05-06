package com.zhouhang.ohsay.base

interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}