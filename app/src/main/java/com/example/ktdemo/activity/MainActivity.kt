package com.example.ktdemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danikula.videocache.HttpProxyCacheServer
import com.example.ktdemo.App
import com.example.ktdemo.R
import com.example.ktdemo.weight.BannerView
import com.newnet.lotteryprinter.adapter.DigitalNewAdapter

class MainActivity : TransparentActivity() {


    var bannerView:BannerView?=null
    var recy_list: RecyclerView?=null
    var digitalNewAdapter:DigitalNewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         bannerView = findViewById(R.id.banner)
         recy_list  = findViewById(R.id.recycler_list)
        initBanner()
        initList()
        initData()

    }


    private fun  initData(){

        var arrayList = ArrayList<String>()
        for (i in 1..100){
            arrayList.add(""+i)
        }
        Log.d("jdsijfsi",""+arrayList.size)
        digitalNewAdapter?.setNewData(arrayList)

    }

    @SuppressLint("WrongConstant")
    private fun initList(){
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recy_list?.layoutManager=linearLayoutManager
        digitalNewAdapter= DigitalNewAdapter(R.layout.item_digital)
        recy_list?.adapter=digitalNewAdapter

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
