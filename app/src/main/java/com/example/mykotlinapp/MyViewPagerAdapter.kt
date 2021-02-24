package com.example.mykotlinapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class MyViewPagerAdapter( fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    val NUM_ITEMS = 3 ;
    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> DetailsFragment() 
            1 -> ActivityStreamFragment()
            2 -> RelatedListFragment()
            else -> DetailsFragment()
        }
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Details"
            1 -> "Active Stream"
            2 -> "Related List"
            else -> null
        }
    }
   
}