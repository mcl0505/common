package com.mcl.commondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.mcl.common.CommonConfig
import com.mcl.common.ext.singleClick
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CommonConfig.init(this,true)
        findViewById<TextView>(R.id.text).singleClick {
            Toast.makeText(this, "${it.tag}", Toast.LENGTH_SHORT).show()
        }
    }
}