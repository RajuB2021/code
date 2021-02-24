package com.example.mykotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RelatedListFragment() : Fragment() {

    private lateinit var list: ArrayList<DetailsFragmentRecyclerViewAdapter.Item>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val textView = TextView(activity)
        textView.setText("TODO")
        return textView
    }
}