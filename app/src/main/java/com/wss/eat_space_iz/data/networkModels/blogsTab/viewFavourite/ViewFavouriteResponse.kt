package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFavourite


import com.google.gson.annotations.SerializedName

data class ViewFavouriteResponse(
    @SerializedName("message")
    val data: ViewFavouriteData,
    @SerializedName("status")
    val status: String
)