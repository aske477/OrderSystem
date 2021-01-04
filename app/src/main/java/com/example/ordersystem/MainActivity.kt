package com.example.ordersystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    private val drinks = ArrayList<Drink>()


    //使用onActivityResult方法，取得返回資料
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //判斷Bundle是否空?
        val b = data?.extras?:return

        if (requestCode==1 && resultCode== Activity.RESULT_OK){
            //新增drink
            drinks.add(Drink(b.getString("name",""),b.getString("suger",""),b.getString("ice","")))
            //更新列表
            adapter.notifyDataSetChanged()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //*****建立LinearLayoutManager物件
        val layoutManager = LinearLayoutManager(this)

        //建立GridLayoutManager
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter(drinks)
        recyclerView.adapter = adapter

        btn_choice.setOnClickListener {
            startActivityForResult(Intent(this,MainActivity2::class.java),1)
        }
    }
}

data class Drink(
    val name: String,
    val suger:String,
    val ice:String
)