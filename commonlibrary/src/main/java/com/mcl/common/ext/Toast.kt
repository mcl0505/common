package com.mcl.common.ext

import com.mcl.common.util.ToastUtil

/**
 * 公司：坤创科技
 * 作者：Android 孟从伦
 * 文件名：Toast
 * 创建时间：2020/9/2
 * 功能描述：
*/

fun String.toast() = ToastUtil.show(this)
