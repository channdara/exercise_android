package com.example.exercise_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_android.R
import com.example.exercise_android.models.Shop
import kotlinx.android.synthetic.main.carousel_maps_item.view.*

class MapsRecyclerAdapter(private val shops: Array<Shop>) : RecyclerView.Adapter<MapsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_maps_item, parent, false)
        return MapsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        holder.bindView(shops.elementAt(holder.adapterPosition))
    }

    override fun getItemCount(): Int = shops.size
}

class MapsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(shop: Shop) {
        view.apply {
            maps_item_shop_name.text = shop.shopName
            maps_item_distance.text = shop.distance.toString()
            maps_item_status.text = shop.shopStatus
        }
    }
}