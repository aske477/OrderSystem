package com.example.ordersystem

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.adapter_vertical.view.*


class MyAdapter constructor(private val layout: Int, private val data: ArrayList<Item>): BaseAdapter() {
    //回傳資料筆數
    override fun  getCount() = data.size
    //回傳某筆項目
    override fun getItem(position: Int) = data[position]
    //回傳某筆ID
    override fun getItemId(position: Int) = 0L
    //取得畫面元件
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val view = View.inflate(parent?.context, layout, null)
            view.img.setImageResource(data[position].photo)
            view.drink_name.text = data[position].name
            return view

    }
}


