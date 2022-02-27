package com.example.exercise_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_android.R
import com.example.exercise_android.models.Shop
import kotlinx.android.synthetic.main.recycler_search_item.view.*

class SearchRecyclerAdapter(
    private val shops: Array<Shop>
) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_search_item, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindView(shops.elementAt(holder.adapterPosition))
    }

    override fun getItemCount(): Int = shops.size

}

class SearchViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bindView(shop: Shop) {
        view.apply {
            shop_item_shop_name.text = shop.shopName
            shop_item_distance.text = shop.distance.toString()
            shop_item_rating.text = shop.rating.toString()
            shop_item_view.text = shop.viewAmount.toString()
            shop_item_rating_and_review.text = shop.ratingAndReview
            shop_item_shop_type.text = shop.getShopType
            shop_item_location.text = shop.location
            shop_item_status.text = shop.shopStatus
        }
    }
}