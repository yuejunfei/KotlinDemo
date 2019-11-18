package com.newnet.lotteryprinter.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.ktdemo.R
import com.example.ktdemo.bean.X


class DigitalNewAdapter : BaseQuickAdapter<X, BaseViewHolder> {



    constructor(@LayoutRes layoutResId: Int, data: List<X>?) : super(layoutResId, data) {}

    constructor(data: List<X>?) : super(data) {}

    constructor(@LayoutRes layoutResId: Int) : super(layoutResId) {}

    /**
     * 这个方法中是为了给holder中对应的view赋值的，使用方式为helper.setText(id,string)
     *
     * @param helper
     * @param item
     */
    override fun convert(helper: BaseViewHolder, item: X?) {
      helper.setText(R.id.tv_zi_item, item!!.result)
        helper.addOnClickListener(R.id.tv_zi_item)
    }

}