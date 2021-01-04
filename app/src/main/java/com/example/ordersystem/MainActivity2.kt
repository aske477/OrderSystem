package com.example.ordersystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.adapter_vertical.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //建立資料來源，並從R類別讀取圖檔資源
        val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.resourceList)
        val arrayname = resources.getStringArray(R.array.drinkresourceList)
        val suger = resources.getStringArray(R.array.suger)
        val ice = resources.getStringArray(R.array.ice)
        var drinkposition:Int= 0




        for (i in 0 until array.length())
            item.add(Item(array.getResourceId(i,0),arrayname[i]))
        array.recycle()

        //設定列數，連結Adapter
        gridview.numColumns = 3
        gridview.adapter = MyAdapter(R.layout.adapter_vertical, item)
        gridview.setOnItemClickListener() { parent, view, position, id ->
            textView3.text = "飲料:(已選擇)"+ arrayname[position]
            drinkposition=position
        }






        button_check.setOnClickListener {
            if (textView3.text == "飲料")
                Toast.makeText(this,"請選擇飲料", Toast.LENGTH_SHORT).show()
            else{
                val bundle = Bundle() //宣告bundle

                bundle.putString("name", arrayname[drinkposition])    //放入飲料名稱

                val sugerchosen = findViewById<Spinner>(R.id.suger).selectedItemPosition
                bundle.putString("suger",suger[sugerchosen]) //放入甜度

                val icechosen = findViewById<Spinner>(R.id.ice).selectedItemPosition
                bundle.putString("ice", ice[icechosen])    //放入冰度

                //setResult將資料回傳
                setResult(Activity.RESULT_OK,Intent().putExtras(bundle))
                finish()
                /*
                val intent = Intent(this,MainActivity::class.java)  //宣告意圖
                intent.putExtras(bundle)
                startActivity(intent)
                */
            }
        }
    }
}
data class Item (
        val photo: Int,
        val name: String
)