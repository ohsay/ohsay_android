package com.zhouhang.ohsay.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.classic.common.MultipleStatusView


/**
 * desc:BaseActivity基类
 */
abstract class BaseActivity : AppCompatActivity() {
    /**
     * 多种状态的 View 的切换
     */
    private var mLayoutStatusView: MultipleStatusView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId())
        initData()
        initView()
        start()
        initListener()
        initEvent()

    }

    private fun initListener() {
        //需要在状态布局中指定特定的id
        mLayoutStatusView?.setOnRetryClickListener { mRetryClickListener }
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

    /**
     *  加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 开始请求
     */
    abstract fun start()


    /**
     * 打开软键盘
     */
    fun openKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

}


