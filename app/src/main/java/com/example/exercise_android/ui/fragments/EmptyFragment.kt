package com.example.exercise_android.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise_android.R
import kotlinx.android.synthetic.main.fragment_empty.view.*

private const val APP_BAR_TITLE = "appbar_title"

class EmptyFragment : Fragment() {
    private var title: String? = null

    companion object {
        fun newInstance(fragment: Fragment, title: String) {
            fragment.arguments = Bundle().apply {
                putString(APP_BAR_TITLE, title)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(APP_BAR_TITLE)
            val item = "item"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            title = it.getString(APP_BAR_TITLE)
            val item = "item"
        }
        val view = inflater.inflate(R.layout.fragment_empty, container, false)
        view.empty_text_view.text = title
        return view
    }


}