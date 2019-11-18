package com.example.ktdemo.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.danikula.videocache.HttpProxyCacheServer
import com.example.ktdemo.App
import com.example.ktdemo.R
import com.example.ktdemo.bean.LotteryBean
import com.example.ktdemo.weight.BannerView
import com.google.gson.Gson
import com.newnet.lotteryprinter.adapter.DigitalNewAdapter
import com.squareup.okhttp.Request
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.fragment_view1.*
import kotlinx.android.synthetic.main.fragment_view1.view.*
import java.lang.Exception

class fragment1 : Fragment() {

    var bannerView: BannerView?=null

    var digitalNewAdapter: DigitalNewAdapter?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view1, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bannerView = activity?.findViewById(R.id.banner)
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
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_list?.layoutManager=linearLayoutManager
        digitalNewAdapter= DigitalNewAdapter(R.layout.item_digital)
        recycler_list?.adapter=digitalNewAdapter

        button1.setOnClickListener {
            Toast.makeText(activity,"1", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(activity,"2", Toast.LENGTH_SHORT).show()
        }


        recycler_list.addOnItemTouchListener(object : OnItemClickListener(){
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                Toast.makeText(activity,"zhu"+position, Toast.LENGTH_SHORT).show()
            }
        })

        digitalNewAdapter!!.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->

            when (view.id) {
                R.id.tv_zi_item ->
                    Toast.makeText(activity,"zi"+position, Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun initBanner() {
        var proxy: HttpProxyCacheServer = App.getProxy(activity!!.applicationContext)
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