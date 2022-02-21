package com.mcl.common.util

import android.widget.Toast
import com.mcl.common.CommonConfig

/**
 * 公司：坤创科技
 * 作者：Android 孟从伦
 * 文件名：ToastUtil
 * 创建时间：2020/8/8
 * 功能描述： 吐司工具类   Android 11 Toast的setView 被废弃，采用基础使用
 */
object ToastUtil {
    private var time: Long = 0
    private var oldMsg: String? = null
    fun toast(msg:String = ""){
        if (msg != oldMsg) {
            create(msg)
            time = System.currentTimeMillis()
        } else {
            if (System.currentTimeMillis() - time > 2000) {
                create(msg)
                time = System.currentTimeMillis()
            }
        }
        oldMsg = msg
    }


    private fun create(massage: String) {
        Toast.makeText(CommonConfig.mContext,massage,Toast.LENGTH_SHORT).show()
    }
}