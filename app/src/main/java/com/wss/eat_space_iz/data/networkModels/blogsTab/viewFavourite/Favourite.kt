package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFavourite


import com.google.gson.annotations.SerializedName

data class Favourite(
    @SerializedName("accepting_order")
    val acceptingOrder: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("profile_status")
    val profileStatus: Boolean,
    @SerializedName("restaurant_name")
    val restaurantName: String
)