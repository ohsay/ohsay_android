package com.zhouhang.ohsay.mvp.model

import com.zhouhang.ohsay.base.BaseBean
import com.zhouhang.ohsay.net.RetrofitManager
import com.zhouhang.ohsay.scheduler.SchedulerUtils
import io.reactivex.Observable

class CodeModel {
    fun requestCode(mobile: String, type: String): Observable<BaseBean<Unit>> {
        return RetrofitManager.service.requestCode(mobile, type)
            .compose(SchedulerUtils.ioToMain())
    }
}