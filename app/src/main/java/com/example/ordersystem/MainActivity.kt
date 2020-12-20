package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_choice.setOnClickListener { startActivity(Intent(this,MainActivity2::class.java)) }

        intent?.extras?.let {
            val data1 = it.getString("name")
            val data2 = it.getString("suger")
            val data3 = it.getString("ice")
            order.text = "飲料:"+data1+"\n\n甜度:"+data2+"\n\n冰塊:"+data3
        }
    }
}

