package com.example.foodmenu

class Food{

    var image:Int? = null
    var price:Int? = null
    var food_details:String? =null
    var name:String? = null

    constructor(name:String,price:Int, food_details:String, image:Int){

        this.price = price
        this.image = image
        this.food_details = food_details
        this.name = name


    }

}