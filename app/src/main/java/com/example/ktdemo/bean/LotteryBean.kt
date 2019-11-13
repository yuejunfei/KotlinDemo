package com.example.ktdemo.bean

data class LotteryBean(
    val extContent: Any,
    val retCode: String,
    val retContent: RetContent,
    val retMessage: Any,
    val success: Boolean
)

data class RetContent(
    val list: List<X>
)

data class X(
    val lottid: Int,
    val period: String,
    val result: String,
    val setdate: Long,
    val srdate: String,
    val status: Int
)