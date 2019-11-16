package com.example.foodmenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFood = ArrayList<Food>()
    var adapter:foodAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load food image//
        listOfFood.add(Food("Burger",13,"Food Details are found here",R.drawable.burger))
        listOfFood.add(Food("Noodle",15,"Food Details are found here",R.drawable.noodle))
        listOfFood.add(Food("Steak",25,"Food Details are found here",R.drawable.steak))
        listOfFood.add(Food("Dessert",10,"Food Details are found here",R.drawable.dessert))
        //
        adapter = foodAdapter(this, listOfFood)
        menu.adapter = adapter


    }

    class foodAdapter: BaseAdapter{

        var listOfFood = ArrayList<Food>()
        var context:Context? = null

        constructor(context: Context, listOfFood:ArrayList<Food>):super(){
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getCount(): Int {

            return listOfFood.size
        }

        override fun getItem(position: Int): Any {

            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.food_ticket,null)
            var food = listOfFood[position]
            var price = food.price

            myView.food_details.text = food.name
            myView.image_food.setImageResource(food.image!!)


            myView.image_food.setOnClickListener{
                val intent = Intent(context, FoodDetail::class.java)
                intent.putExtra("details", food.food_details)
                intent.putExtra("price",price.toString())
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }




            return myView

        }


    }
}
