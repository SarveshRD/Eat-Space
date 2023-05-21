package com.wss.eat_space_iz.data.networkModels.profileTab.removeFavourite


import com.google.gson.annotations.SerializedName

data class RemoveFavouriteRequest(
    @SerializedName("restaurant_id")
    val restaurantId: Int,
    @SerializedName("user_id")
    val userId: Int
)