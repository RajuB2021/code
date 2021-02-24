package com.example.mykotlinapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView

class DetailsFragmentRecyclerViewAdapter(context : Context, list:ArrayList<Item>) : RecyclerView.Adapter<DetailsFragmentRecyclerViewAdapter.MyViewHolder>() {
    val context = context ;
    val list = list ;
    
    class MyViewHolder(view: View,viewType:Int) : RecyclerView.ViewHolder(view){
        val textView1 :TextView  =  view.findViewById(R.id.itemTextView1)
        val textView2 :TextView  =  view.findViewById(R.id.itemTextView2); 
        var imageView: ImageView? = null
        init {
            if (viewType == 1){
                imageView  = view.findViewById(R.id.itemImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

      var inflater =  LayoutInflater.from(parent.context)
        var view: View ;
        if(viewType == 0)
            view = inflater.inflate(R.layout.recycler_rowlayout1,parent,false)
        else
            view = inflater.inflate(R.layout.recyclerview_rowlayout2,parent,false)
        
        return MyViewHolder(view,viewType);
        
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var item : Item = list[position]
        holder.textView1.text = item.itemText1 ;
        holder.textView2.text = item.itemText2 ;
        
        if(item.viewType == 1) {
            if (item.itemImageSrc != null) {
                val ImageId: Int = context.getResources().getIdentifier(item.itemImageSrc, "drawable", context.getPackageName())
                val drawable: Drawable? = AppCompatResources.getDrawable(context, ImageId)
                holder.imageView?.setImageDrawable(drawable)
            } else {
                holder.imageView?.setImageDrawable(null)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType ;
        }
    
    class Item(tv1:String, tv2:String ? ,imageSrc:String?,viewType:Int) {
        val itemText1 = tv1 ;
        val itemText2 = tv2 ;
        val itemImageSrc = imageSrc ;
        val viewType = viewType ;
    }
}