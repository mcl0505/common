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

    fun show(content: String?=null) {
        if (content == null)return

        Toast.makeText(CommonConfig.mContext,content,Toast.LENGTH_SHORT).show()
    }
}