package com.mcl.common.util

import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/2/23
 * 功能描述：数据临时存储
 */
object MmkvUtil {
    private lateinit var rootDir:String
    private lateinit var kv:MMKV
    private val keyList:MutableList<String> = ArrayList()
    fun init(context: Context){
        rootDir = MMKV.initialize(context)
        kv = MMKV.defaultMMKV()!!
    }

    /**
     * 存数据
     */
    fun <T> putValue(key:String, value: T){
        keyList.add(key)
        when(value){
            is Int -> kv.encode(key,value as Int)
            is String -> kv.encode(key,value as String)
            is Long -> kv.encode(key,value as Long)
            is Float -> kv.encode(key,value as Float)
            is Double -> kv.encode(key,value as Double)
            is Boolean -> kv.encode(key, value as Boolean)
        }
    }

    /**
     * 取数据
     */
    fun <T> getValue(key: String,default:T):T = when(default){
        is Int -> kv.decodeInt(key) as T
        is String -> kv.decodeString(key) as T
        is Long -> kv.decodeLong(key) as T
        is Float -> kv.decodeFloat(key) as T
        is Double -> kv.decodeDouble(key) as T
        is Boolean -> kv.decodeBool(key) as T
        else -> default
    }

    /**
     * 移除某一个储存的数据
     * 移除指定的key  null=移除全部的储存
     */
    fun clean(key: String?=null){
        if (key == null){
            kv.removeValuesForKeys(keyList.toTypedArray())
        }else{
            kv.removeValueForKey(key)
            keyList.remove(key)
        }

    }
}