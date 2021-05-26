package com.mcl.common.util

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.mcl.common.CommonConfig


/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/2/23
 * 功能描述：获取AndroidManifes 中配置的数据
 */
object AndroidManifestUtil {
    fun getMetaData(key: String):String{
        var res = ""
        try {
            val appInfo: ApplicationInfo = CommonConfig.mContext.getPackageManager().getApplicationInfo(CommonConfig.mContext.getPackageName(), PackageManager.GET_META_DATA)
            res = appInfo.metaData.getString(key)!!
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return res
    }
}