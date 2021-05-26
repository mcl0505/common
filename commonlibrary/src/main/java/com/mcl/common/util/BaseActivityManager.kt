package com.mcl.common.util

import android.app.Activity
import android.content.Context
import com.mcl.common.ext.yes
import java.util.*

/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/2/19
 * 功能描述：
 */
/**
 * UI管理类,任何地方可以安全退出程序
 */
object BaseActivityManager {
    val isActivityStackEmpty: Boolean
        get() = activityStack.empty()

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        try {
            return activityStack.lastElement()
        } catch (e: Exception) {
            return null
        }

    }

    /**
     * 获取当前Activity的前一个Activity
     */
    fun preActivity(): Activity? {
        val index = activityStack.size - 2
        return if (index < 0) {
            null
        } else activityStack[index]
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        val activity = activityStack.lastElement()
        finishActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        activityStack.remove(activity)
        activity?.finish()
    }

    /**
     * 移除指定的Activity
     */
    fun removeActivity(activity: Activity?) {
        activityStack.remove(activity)
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        try {
            for (activity in activityStack) {
                if (activity.javaClass == cls) {
                    finishActivity(activity)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {

        activityStack.forEach {
            (it != null).yes { it.finish() }
        }

        activityStack.clear()

    }

    /**
     * 返回到指定的activity
     *
     * @param cls
     */
    fun returnToActivity(cls: Class<*>) {
        while (activityStack.size != 0)
            if (activityStack.peek().javaClass == cls) {
                break
            } else {
                finishActivity(activityStack.peek())
            }
    }


    /**
     * 是否已经打开指定的activity
     * @param cls
     * @return
     */
    fun isOpenActivity(cls: Class<*>): Boolean {
        if (activityStack != null) {
            var i = 0
            val size = activityStack.size
            while (i < size) {
                if (cls == activityStack.peek().javaClass) {
                    return true
                }
                i++
            }
        }
        return false
    }

    /**
     * 退出应用程序
     *
     * @param context      上下文
     * @param isBackground 是否开开启后台运行
     */
    fun appExit(context: Context, isBackground: Boolean? = false) {
        try {
            finishAllActivity()
            val activityMgr =
                context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            activityMgr.restartPackage(context.packageName)
        } catch (e: Exception) {

        } finally {
            // 注意，如果您有后台程序运行，请不要支持此句子
            if ((!isBackground!!)!!) {
                System.exit(0)
            }
        }
    }

    var activityStack: Stack<Activity> = Stack()
        private set



}