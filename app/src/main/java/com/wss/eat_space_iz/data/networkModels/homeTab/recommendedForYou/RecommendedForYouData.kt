package com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou


import com.google.gson.annotations.SerializedName

data class RecommendedForYouData(
    @SerializedName("availability")
    val availability: String,
    @SerializedName("category")
    val category: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("item_name")
    val itemName: String,
    @SerializedName("menu_img")
    val menuImg: String,
    @SerializedName("out_of_stock")
    val outOfStock: Boolean,
    @SerializedName("price")
    val price: Int,
    @SerializedName("restaurant")
    val restaurant: Int,
    @SerializedName("veg")
    val veg: Boolean
)