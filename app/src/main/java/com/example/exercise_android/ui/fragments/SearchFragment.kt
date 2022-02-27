package com.example.exercise_android.ui.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_android.R
import com.example.exercise_android.adapter.SearchRecyclerAdapter
import com.example.exercise_android.models.Shop
import com.example.exercise_android.ui.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment() {

    private var clickToShowMap: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEditText()
        setupRecyclerView()
        setupListener()
    }

    private fun setupEditText() {
        view?.apply {
            search_edit_text.setOnEditorActionListener { _, actionID, _ ->
                search_edit_text.clearFocus()
                (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(windowToken, 0)
                when (actionID) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        search_progress_bar.visibility = View.VISIBLE
                        search_total_restaurant.visibility = View.GONE
                        search_recycler_view.visibility = View.GONE
                        Handler(Looper.getMainLooper()).postDelayed({
                            search_progress_bar.visibility = View.GONE
                            search_total_restaurant.visibility = View.VISIBLE
                            search_recycler_view.visibility = View.VISIBLE
                        }, 2000)
                    }
                }
                false
            }
        }
    }

    private fun setupRecyclerView() {
        view?.apply {
            search_total_restaurant.text = "${Shop.tmpShops.size} restaurants found"
            search_recycler_view.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = SearchRecyclerAdapter(Shop.tmpShops)
            }
        }
    }

    private fun setupListener() {
        view?.apply {
            val mainActivity = (activity as MainActivity)
            search_button_back.setOnClickListener {
                mainActivity.removeFragment(mainActivity.searchFragment)
            }
            search_button_map.setOnClickListener {
                if (clickToShowMap) {
                    search_button_map.setImageResource(R.drawable.ic_list)
                    clickToShowMap = !clickToShowMap
                    MapsFragment.newInstance(mainActivity.mapsFragment, Shop.tmpShops)
                    mainActivity.addFragment(mainActivity.mapsFragment)
                    return@setOnClickListener
                }
                search_button_map.setImageResource(R.drawable.ic_public)
                clickToShowMap = !clickToShowMap
                mainActivity.removeFragment(mainActivity.mapsFragment)
            }
        }
    }
}