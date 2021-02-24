package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    private lateinit var  fm : FragmentManager ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) ;
        
        val fragmentManager : FragmentManager  =  this.getSupportFragmentManager();
        setContentView(R.layout.activity_main)
        
         val myViewPagerAdapter = MyViewPagerAdapter(fragmentManager)
        val viewPager: ViewPager = findViewById(R.id.vpPager)
        viewPager.adapter = myViewPagerAdapter ;
    }
} 