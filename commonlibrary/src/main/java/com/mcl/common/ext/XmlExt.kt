package com.mcl.common.ext

import android.graphics.drawable.Drawable
import com.mcl.common.CommonConfig

/**
 * 公司：坤创科技
 * 作者：Android 孟从伦
 * 创建时间：2020/11/4
 * 功能描述：
 */

//获取颜色
fun Int.getColor() : Int = CommonConfig.mContext.resources.getColor(this)

fun Int.getDrawable() : Drawable = CommonConfig.mContext.resources.getDrawable(this)

fun Int.getString() : String = CommonConfig.mContext.resources.getString(this)

fun Int.getStringArray() : List<String> = CommonConfig.mContext.resources.getStringArray(this).toList() as List<String>

