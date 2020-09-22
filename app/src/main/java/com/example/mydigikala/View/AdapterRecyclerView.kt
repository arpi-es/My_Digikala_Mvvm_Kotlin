package com.example.mydigikala.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mydigikala.ProductPourforsh
import com.example.mydigikala.R
import com.example.mydigikala.Repository.Api
import com.example.mydigikala.databinding.ItemsRecyclerviewBinding

class AdapterRecyclerView(private val lstProductPourforsh: List<ProductPourforsh>) : RecyclerView.Adapter<AdapterRecyclerView.AdapterRecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerViewHolder {

        return AdapterRecyclerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.items_recyclerview, parent, false
            )
        )
    }


    override fun getItemCount(): Int {
        return lstProductPourforsh.size
    }

    override fun onBindViewHolder(holder: AdapterRecyclerViewHolder, position: Int) {
        var item = lstProductPourforsh[position]
        item.pic = item.pic.replace("http://localhost",  Api.myIP)
        holder.items.data = item!!

        if (position == 0) {
            holder.items.items0.visibility = View.VISIBLE
            holder.items.items.visibility = View.GONE
        } else {
            holder.items.items0.visibility = View.GONE
            holder.items.items.visibility = View.VISIBLE
        }

    }


    class AdapterRecyclerViewHolder(val items: ItemsRecyclerviewBinding) :
        RecyclerView.ViewHolder(items.root) {

    }




}