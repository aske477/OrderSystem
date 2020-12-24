package com.example.ordersystem

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.adapter_vertical.view.*


class MyAdapter (private val layout: Int, private val data: ArrayList<Item>): BaseAdapter() {

    private class ViewHolder {
        lateinit var img: ImageView
        lateinit var drink_name: TextView
    }

    //回傳資料筆數
    override fun  getCount() = data.size
    //回傳某筆項目
    override fun getItem(position: Int) = data[position]
    //回傳某筆ID
    override fun getItemId(position: Int) = 0L
    //取得畫面元件
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View
        val holder : ViewHolder

        if(convertView ==null) {
            //建立新的View
            view = View.inflate(parent?.context, layout, null)
            holder = ViewHolder()
            view.tag = holder   //幫View加上標籤，以便重複使用

            //連結畫面中的元件
            holder.img = view.findViewById(R.id.img)
            holder.drink_name = view.findViewById(R.id.drink_name)
        }else {
            //重複使用已存在的View
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.img.setImageResource(data[position].photo)
        holder.drink_name.text = data[position].name
        return view
    }
}


