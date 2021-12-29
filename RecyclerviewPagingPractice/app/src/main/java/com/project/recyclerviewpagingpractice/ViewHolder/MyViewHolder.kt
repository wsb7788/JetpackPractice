package com.project.recyclerviewpagingpractice.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.recyclerviewpagingpractice.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var img_thumbnail:ImageView
    var txt_title:TextView
    init{
        img_thumbnail = itemView.findViewById(R.id.img_thumbnail) as ImageView
        txt_title = itemView.findViewById(R.id.txt_title) as TextView
    }

}