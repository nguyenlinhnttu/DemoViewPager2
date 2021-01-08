package com.android.demoviewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by NguyenLinh on 08,January,2021
 */
class CardAdapter(var arrFoods: List<FoodEntity>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(arrFoods[position].image)
    }

    override fun getItemCount(): Int {
        return arrFoods.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView = itemView.findViewById(R.id.image)
}