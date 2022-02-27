package com.example.exercise_android.models

import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

class Shop(
    val image: String = "",
    val shopName: String,
    val ratingAndReview: String = "No Rating | No review",
    val location: String = "Kandal",
    val shopStatus: String = "Open Now",
    val rating: Double = 0.0,
    val distance: Double,
    val shopType: Int,
    val viewAmount: Int,
    val latLng: LatLng,
) : Serializable {
    companion object {
        val tmpShops: Array<Shop> = arrayOf(
            Shop(
                shopName = "Piseth Coffee",
                distance = 0.2,
                shopType = 1,
                viewAmount = 16,
                latLng = LatLng(11.4680461, 104.8945179),
            ),
            Shop(
                shopName = "Nice Coffee",
                distance = 0.3,
                shopType = 1,
                viewAmount = 23,
                latLng = LatLng(11.4700865, 104.9600957),
            ),
            Shop(
                shopName = "Conexion Coffee & Pub",
                distance = 0.8,
                shopType = 2,
                viewAmount = 22,
                latLng = LatLng(11.4764915, 104.9493042),
            ),
            Shop(
                shopName = "K&T COFFEE Mr. KHAN TEY",
                distance = 0.9,
                shopType = 1,
                viewAmount = 32,
                latLng = LatLng(11.4765135, 104.9409964),
            ),
            Shop(
                shopName = "My Heart Coffee & Pub",
                distance = 0.9,
                shopType = 2,
                viewAmount = 15,
                latLng = LatLng(11.4779917, 104.9472387),
            ),
            Shop(
                shopName = "Troll Coffee",
                distance = 1.0,
                shopType = 1,
                viewAmount = 25,
                latLng = LatLng(11.4643801, 104.953636),
            ),
        )
    }

    val getShopType: String
        get() = when (shopType) {
            1 -> "Coffee · Ice-Cream"
            2 -> "Pub · Bar"
            else -> ""
        }
}