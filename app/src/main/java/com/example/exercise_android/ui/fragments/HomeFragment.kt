package com.example.exercise_android.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_android.R
import com.example.exercise_android.adapter.CouponRecyclerAdapter
import com.example.exercise_android.ui.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCouponRecyclerView()
        setupListener()
    }

    private fun setupCouponRecyclerView() {
        view?.home_recycler_view?.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = CouponRecyclerAdapter()
        }
    }

    private fun setupListener() {
        view?.apply {
            home_search_button?.setOnClickListener {
                val mainActivity = (activity as MainActivity)
                mainActivity.addFragment(mainActivity.searchFragment)
            }
        }
    }
}