package com.example.ktdemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter


class BannerViewAdapter(list: List<View>?) : PagerAdapter() {

    private var listBean: List<View>? =null

    init {
        var list: List<View>? =list
        if (list==null){
            list=ArrayList()

        }
        this.listBean=list

    }

    fun setDataList(list: List<View>?){
        if (list!=null&&list.size>0){
            this.listBean=list
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = listBean!!.get(position)
        container.addView(view)
        return view
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }


    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0==p1
    }

    override fun getCount(): Int {
        return listBean!!.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}