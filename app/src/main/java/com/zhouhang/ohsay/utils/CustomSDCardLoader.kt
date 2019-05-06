package com.zhouhang.ohsay.utils

import android.content.Context
import skin.support.load.SkinSDCardLoader
import skin.support.utils.SkinFileUtils
import java.io.File

class CustomSDCardLoader : SkinSDCardLoader() {

    companion object {

        const val SKIN_LOADER_STRATEGY_SDCARD = Integer.MAX_VALUE
    }

    override fun getSkinPath(context: Context?, skinName: String?): String {
        return File(SkinFileUtils.getSkinDir(context), skinName).absolutePath
    }

    override fun getType(): Int {
        return SKIN_LOADER_STRATEGY_SDCARD
    }
}