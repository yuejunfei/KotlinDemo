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


    var bannerView:BannerView?=null

    var digitalNewAdapter:DigitalNewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         bannerView = findViewById(R.id.banner)
        initBanner()
        initList()
        initData()

    }


    private fun  initData(){

//        var arrayList = ArrayList<String>()
//        for (i in 1..100){
//            arrayList.add(""+i)
//        }
//        Log.d("jdsijfsi",""+arrayList.size)
//        digitalNewAdapter?.setNewData(arrayList)
        OkHttpUtils
                .get()
                .url("http://liangjian.2858.cn/newnet-football-lottery-recommend/lottery/lotteryResult")
                .build()
                .execute(object : StringCallback(){
                    override fun onResponse(response: String?) {

                        val fromJson = Gson().fromJson(response, LotteryBean::class.java)
                        val retContent = fromJson.retContent
                        val list = retContent.list
                        digitalNewAdapter?.setNewData(list)
                    }

                    override fun onError(request: Request?, e: Exception?) {

                    }

                })

    }

    @SuppressLint("WrongConstant")
    private fun initList(){
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_list?.layoutManager=linearLayoutManager
        digitalNewAdapter= DigitalNewAdapter(R.layout.item_digital)
        recycler_list?.adapter=digitalNewAdapter

        button1.setOnClickListener {
             Toast.makeText(this,"1",Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(this,"2",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initBanner() {
        var proxy:HttpProxyCacheServer= App.getProxy(applicationContext)
        var proxyUrl:String = proxy.getProxyUrl("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")

        var bannerList = mutableListOf<String>()
        bannerList.add( "http://liangjian.2858.cn:9100/images/newnet-pic/attach/football/uploads/attach/7cbfdd91-b8e4-4cb5-b29b-6eec85018508.jpg" )
        bannerList.add( proxyUrl )
        bannerList.add("http://liangjian.2858.cn:9100/images/newnet-pic/attach/football/uploads/attach/31189a2d-fc59-4570-a1fe-d37dd3ce9994.jpg" )

        bannerView?.setDataList(bannerList)
        bannerView?.setImgDelyed(5000)
        bannerView?.startBanner()
        bannerView?.startAutoPlay()

    }


    override fun onDestroy() {
        bannerView?.destroy()
        super.onDestroy()
    }
}
