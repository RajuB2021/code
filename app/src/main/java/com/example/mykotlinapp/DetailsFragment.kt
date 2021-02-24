package com.example.mykotlinapp

import android.content.Context
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DetailsFragment() : Fragment() {
    private lateinit var list: ArrayList<DetailsFragmentRecyclerViewAdapter.Item>;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createData()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var recyclerView: RecyclerView? 
        val context: Context = activity as Context
        recyclerView = RecyclerView(context);
        recyclerView.layoutManager = LinearLayoutManager(context)

        // create divider and sets padding to it 
        val ATTRS = intArrayOf(android.R.attr.listDivider)
        val a = context.obtainStyledAttributes(ATTRS)
        val divider = a.getDrawable(0)
        val padding = context.resources.getDimensionPixelSize(R.dimen.padding)
        val inset = padding
        val insetDivider = InsetDrawable(divider, inset, 0, inset, 0)
        a.recycle()

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(insetDivider)
        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.adapter = DetailsFragmentRecyclerViewAdapter(context, list);
        return recyclerView;

    }

    fun createData() {
        list = ArrayList();
        // Note viewType 1 is used for layout with ImageView where as viewType 0 is used for layout without ImageView .
        list.add(DetailsFragmentRecyclerViewAdapter.Item("Number", "INC012345", null, 0)); 
        list.add(DetailsFragmentRecyclerViewAdapter.Item("Description", null, null, 0));
        list.add(DetailsFragmentRecyclerViewAdapter.Item("Opened ", "2021-02-24 13:11:05", null, 0));
        list.add(DetailsFragmentRecyclerViewAdapter.Item("decimal_test", null, null, 0));
        list.add(DetailsFragmentRecyclerViewAdapter.Item("Mobile Phone", "8989622251", "phone", 1));
        list.add(DetailsFragmentRecyclerViewAdapter.Item("Email", "raju.bonagiri@gmail.com", "mail", 1));
    }

}