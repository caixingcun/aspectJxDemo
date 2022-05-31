package com.ymt.aoptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ymt.aoptest.realname.RealNameCheck

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv).setOnClickListener {
            goToMineCenter()
        }
    }

    @RealNameCheck
    private fun goToMineCenter() {
        Log.d("tag","进了我的页面")
    }
}