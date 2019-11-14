package com.example.ktdemo.activity

import android.os.Bundle
import android.widget.RadioGroup
import androidx.fragment.app.FragmentTransaction
import com.example.ktdemo.R
import com.example.ktdemo.fragment.fragment1
import com.example.ktdemo.fragment.fragment2
import com.example.ktdemo.fragment.fragment3
import com.example.ktdemo.fragment.fragment4
import kotlinx.android.synthetic.main.activity_homepage.*

class HomePageActivity : TransparentActivity(), RadioGroup.OnCheckedChangeListener {


    var fragment1:fragment1?=null
    var fragment2: fragment2?=null
    var fragment3: fragment3?=null
    var fragment4: fragment4?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        initView()
    }

    private fun initView(){
        fragment1 = fragment1()
        supportFragmentManager.beginTransaction().add(R.id.main_framelayout, fragment1!!).commit()
        rg_tabs.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        val ft = supportFragmentManager.beginTransaction()
        hideAllFragment(ft)
        when(p1){
            R.id.rg_tabs_one->
                if (fragment1!=null){
                    ft.show(fragment1!!).commit()
            }else{
                 fragment1= fragment1()
                    ft.add(R.id.main_framelayout, fragment1!!).commit()
            }

            R.id.rg_tabs_two->
                if (fragment2!=null){
                    ft.show(fragment2!!).commit()
                }else{
                    fragment2= fragment2()
                    ft.add(R.id.main_framelayout, fragment2!!).commit()
                }

            R.id.rg_tabs_three->
                if (fragment3!=null){
                    ft.show(fragment3!!).commit()
                }else{
                    fragment3= fragment3()
                    ft.add(R.id.main_framelayout, fragment3!!).commit()
                }

            R.id.rg_tabs_four->
                if (fragment4!=null){
                    ft.show(fragment4!!).commit()
                }else{
                    fragment4= fragment4()
                    ft.add(R.id.main_framelayout, fragment4!!).commit()
                }
        }

    }

    private fun hideAllFragment(ft:FragmentTransaction){
        if (fragment1!=null)ft.hide(fragment1!!)
        if (fragment2!=null)ft.hide(fragment2!!)
        if (fragment3!=null)ft.hide(fragment3!!)
        if (fragment4!=null)ft.hide(fragment4!!)
    }
}