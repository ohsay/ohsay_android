package com.zhouhang.ohsay.utils

import android.content.Context
import android.widget.ImageView
import com.zhouhang.ohsay.GlideApp

object GlideUtils {

    fun loadUrlImage(context: Context, url: Any, imageView: ImageView) {
        GlideApp.with(context)
                .load(url)
//                    .error(R.drawable.ic_hot_normal) //加载失败
//                    .placeholder(R.drawable.ic_hot_normal) //加载中
                .into(imageView)
    }

}