package com.android.demoviewpager2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foods = mutableListOf<FoodEntity>()
        foods.add(FoodEntity("Food 1", R.drawable.image_1))
        foods.add(FoodEntity("Food 2", R.drawable.image_2))
        foods.add(FoodEntity("Food 3", R.drawable.image_3))
        foods.add(FoodEntity("Food 4", R.drawable.image_4))
        foods.add(FoodEntity("Food 5", R.drawable.image_1))
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.pagerOffset).toFloat()
        viewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = FoodCardAdapter(foods, this@MainActivity)
            //adapter = CardAdapter(foods)
            offscreenPageLimit = 3
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val absPosition = abs(position)
            val MAX_ALPHA = 1.0f
            val MIN_ALPHA = 0.7f
            page.alpha = MAX_ALPHA - (MAX_ALPHA - MIN_ALPHA) * absPosition
        }
        //For FoodCardAdapter
        val rv : RecyclerView = viewPager.getChildAt(0) as RecyclerView
        rv.setPadding(200,0,200,0)
        rv.clipToPadding = false

        /* for CardAdapter
        compositePageTransformer.addTransformer { page, position ->
            val offset = position * -(2 * pageOffset + pageMargin)
            if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }

        }
        */
        viewPager.setPageTransformer(compositePageTransformer)
        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position ->
            tab.text = foods[position].name
        }.attach()
    }
}