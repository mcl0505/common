package com.mcl.common

import android.content.Context
import com.mcl.common.util.MmkvUtil

/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/5/26
 * 功能描述：
 */
object CommonConfig {
    lateinit var mContext: Context
    var isLog = false

    fun init(context: Context,isLog:Boolean){
        mContext = context
        this.isLog = isLog

        MmkvUtil.init(mContext)
    }
}