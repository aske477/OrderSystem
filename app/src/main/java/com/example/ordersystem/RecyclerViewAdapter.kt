package com.example.ordersystem


import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val drinks:ArrayList<Drink>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //實作RecyclerView.ViewHolder來緩存View
    //ViewHolder用途:重複利用View放新的資料
    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        //宣告畫面連結
        val drink_name: TextView = v.findViewById(R.id.nameview)
        val drink_suger: TextView = v.findViewById(R.id.sugerview)
        val drink_ice: TextView = v.findViewById(R.id.iceview)
        val drink_delete: Button = v.findViewById(R.id.delete)
    }


    //建立ViewHolder，並連結畫面
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.drink_item,viewGroup,false)
        return ViewHolder(v)
    }


    //將元件與資料綁定
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.drink_name.text = drinks[position].name
        holder.drink_suger.text = drinks[position].suger
        holder.drink_ice.text = drinks[position].ice
        holder.drink_delete.setOnClickListener {
            //移除Drink Item
            drinks.removeAt(position)
            //更新資料表
            notifyDataSetChanged()
        }
    }


    //回傳資料筆數
    override fun getItemCount() = drinks.size
}
