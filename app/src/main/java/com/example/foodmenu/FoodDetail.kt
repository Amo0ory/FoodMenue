package com.example.foodmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)


        val bundle = intent.extras

        image_food.setImageResource(bundle!!.getInt("image"))
        food_price.text = bundle.getString("price")
        food_details.text = bundle.getString("details")

    }


}
