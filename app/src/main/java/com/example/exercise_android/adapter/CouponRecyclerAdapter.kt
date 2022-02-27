package com.example.exercise_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_android.R

class CouponRecyclerAdapter : RecyclerView.Adapter<CouponViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_coupon_item, parent, false)
        return CouponViewHolder(view)
    }

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {}

    override fun getItemCount(): Int = 3
}

class CouponViewHolder(view: View) : RecyclerView.ViewHolder(view)