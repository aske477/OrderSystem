package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.adapter_vertical.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //建立資料來源，並從R類別讀取圖檔資源
        val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.resourceList)
        val arrayname = resources.getStringArray(R.array.drinkresourceList)
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
                val sugerchosen = suger.findViewById<RadioButton>(suger.checkedRadioButtonId).text
                bundle.putString("suger",sugerchosen.toString()) //放入甜度
                val icechosen = ice.findViewById<RadioButton>(ice.checkedRadioButtonId).text
                bundle.putString("ice",icechosen.toString())    //放入冰度

                val intent = Intent(this,MainActivity::class.java)  //宣告意圖
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}
data class Item (
        val photo: Int,
        val name: String
)