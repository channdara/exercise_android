package com.example.exercise_android.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_android.R
import com.example.exercise_android.adapter.CouponRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var homeView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeView = inflater.inflate(R.layout.fragment_home, container, false)

        initCouponRecyclerView()
        initListener()

        return homeView
    }

    private fun initCouponRecyclerView() {
        homeView.home_recycler_view.apply {
            layoutManager = LinearLayoutManager(
                homeView.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = CouponRecyclerAdapter()
        }
    }

    private fun initListener() {
        homeView.home_search_button.setOnClickListener {
            Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
        }
    }
}