package com.mcl.common.ext

import android.os.SystemClock
import android.view.View
import com.mcl.common.R

/**
 * 公司：坤创科技
 * 作者：Android 孟从伦
 * 创建时间：2020/10/24
 * 功能描述：
 */

/**
 * 防止快速点击造成打开多个界面
 */
fun <T : View> T.singleClick(time: Int = 500, block: (T) -> Unit) {
    this.setOnClickListener {

        val curClickTime = SystemClock.uptimeMillis()
        val lastClickTime = (it.getTag(R.id.singleClickId) as Long) ?: 0
        if (curClickTime - lastClickTime >= time) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            it.setTag(R.id.singleClickId, curClickTime)
            block(it as T)
        }
    }
}

/**
 * view 显示隐藏
 */
fun View.visibleOrGone(show: Boolean) {
    if (show) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

