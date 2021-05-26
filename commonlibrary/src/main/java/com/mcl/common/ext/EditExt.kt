package com.mcl.common.ext

import android.text.Editable
import android.widget.EditText

/**
 * 公司：坤创科技有限公司
 * 作者：Android 孟从伦
 * 创建时间：2021/3/22
 * 功能描述：
 */

fun EditText.setEditContent(text:String){
    this.text = Editable.Factory.getInstance().newEditable(text)
}