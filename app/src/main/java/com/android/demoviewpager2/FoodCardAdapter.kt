package com.android.demoviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by NguyenLinh on 08,January,2021
 */
class FoodCardAdapter(var arrFoods: List<FoodEntity>, activity: FragmentActivity) :
    FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {
        return arrFoods.size
    }

    override fun createFragment(position: Int): Fragment {
        return FoodCardFragment.newInstance(arrFoods[position])
    }

}