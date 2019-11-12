package com.newnet.lotteryprinter.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.ktdemo.R


class DigitalNewAdapter : BaseQuickAdapter<String, BaseViewHolder> {



    constructor(@LayoutRes layoutResId: Int, data: List<String>?) : super(layoutResId, data) {}

    constructor(data: List<String>?) : super(data) {}

    constructor(@LayoutRes layoutResId: Int) : super(layoutResId) {}

    /**
     * 这个方法中是为了给holder中对应的view赋值的，使用方式为helper.setText(id,string)
     *
     * @param helper
     * @param item
     */
    override fun convert(helper: BaseViewHolder, item: String?) {
      helper.setText(R.id.tv_zi_item,item)
    }

}