package com.zhouhang.ohsay.scheduler

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}
