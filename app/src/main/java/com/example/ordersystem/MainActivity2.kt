package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button_check.setOnClickListener {
            if (drink_name.length()<1)
                Toast.makeText(this,"請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            else{
                val bundle = Bundle() //宣告bundle
                bundle.putString("name", drink_name.text.toString())    //放入飲料名稱
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