package com.example.exercise_android.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise_android.R
import com.example.exercise_android.adapter.MapsRecyclerAdapter
import com.example.exercise_android.models.Shop
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager
import kotlinx.android.synthetic.main.fragment_maps.view.*

class MapsFragment : Fragment(), OnMapReadyCallback {

    companion object {
        const val SHOP_LIST = "shop_list"

        fun newInstance(fragment: MapsFragment, shops: Array<Shop>) {
            fragment.arguments = Bundle().apply {
                putSerializable(SHOP_LIST, shops)
            }
        }
    }

    private lateinit var googleMap: GoogleMap
    private lateinit var shops: Array<Shop>
    private val markers: ArrayList<MarkerOptions> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            shops = it.getSerializable(SHOP_LIST) as Array<Shop>
            shops.forEach { shop ->
                markers.add(MarkerOptions().apply {
                    position(shop.latLng)
                    title(shop.shopName)
                })
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_maps, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val maps = childFragmentManager.findFragmentById(R.id.maps_fragment) as SupportMapFragment
        maps.getMapAsync(this)
        setupRecyclerView()
    }

    override fun onMapReady(mMap: GoogleMap) {
        googleMap = mMap
        markers.forEach { marker -> googleMap.addMarker(marker) }
        moveMapCamera(shops.first().latLng)
    }

    private fun moveMapCamera(latLng: LatLng) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15F))
    }

    private fun setupRecyclerView() {
        view?.maps_recycler_view?.apply {
            adapter = MapsRecyclerAdapter(shops)
            setIntervalRatio(0.8F)
            setItemSelectListener(object : CarouselLayoutManager.OnSelected {
                override fun onItemSelected(position: Int) {
                    moveMapCamera(shops.elementAt(position).latLng)
                }
            })
        }
    }
}