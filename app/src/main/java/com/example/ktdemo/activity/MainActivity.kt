package com.example.ktdemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danikula.videocache.HttpProxyCacheServer
import com.example.ktdemo.App
import com.example.ktdemo.R
import com.example.ktdemo.bean.LotteryBean
import com.example.ktdemo.weight.BannerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.newnet.lotteryprinter.adapter.DigitalNewAdapter
import com.squareup.okhttp.Request
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : TransparentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



}
