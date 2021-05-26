package com.mcl.common.util

import com.easy.library.utils.AppExecutors
import java.util.concurrent.TimeUnit

/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/5/6
 * 功能描述：
 */
object AppExecutorsHelper {

    /**
     * 更新UI 线程
     */
    fun uiHandler(block: () -> Unit) {
        AppExecutors.mainThread().execute{
            block()
        }
    }

    /**
     * 更新UI 线程
     */
    fun ioHandler(block: () -> Unit) {
        AppExecutors.diskIO().execute{
            block()
        }
    }

    /**
     * 更新UI 线程
     */
    fun httpHandler(block: () -> Unit) {
        AppExecutors.networkIO().execute{
            block()
        }
    }

    /**
     * 延时
     * @param block 执行的方法
     * @param delayMillis 延时的时间  秒
     */
    fun postDelayed(block: () -> Unit, delayMillis: Long = 2) {
        AppExecutors.schedule().schedule({
            block()
        }, delayMillis, TimeUnit.SECONDS)
    }


}