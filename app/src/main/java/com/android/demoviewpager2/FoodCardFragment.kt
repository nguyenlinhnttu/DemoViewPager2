package com.android.demoviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_food_card.*

/**
 * Created by NguyenLinh on 08,January,2021
 */
class FoodCardFragment : Fragment() {
    companion object {
        fun newInstance (foodEntity: FoodEntity) :FoodCardFragment{
            val fragment = FoodCardFragment()
            val bundle = Bundle()
            bundle.putSerializable("Food_Arg",foodEntity)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_food_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val food  = arguments?.getSerializable("Food_Arg") as FoodEntity
        image.setImageResource(food.image)
    }
}