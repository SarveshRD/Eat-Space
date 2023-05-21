package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: Int,
    @SerializedName("item")
    val item: Int,
    @SerializedName("item_name")
    val itemName: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("veg")
    val veg: String
)