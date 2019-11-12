package com.example.ktdemo.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

import com.gyf.barlibrary.ImmersionBar

open class TransparentActivity : FragmentActivity() {

    var mImmersionBar: ImmersionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mImmersionBar= ImmersionBar.with(this)
        mImmersionBar?.statusBarDarkFont(true)?.init()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mImmersionBar!=null){
            mImmersionBar?.destroy()
        }
    }
}