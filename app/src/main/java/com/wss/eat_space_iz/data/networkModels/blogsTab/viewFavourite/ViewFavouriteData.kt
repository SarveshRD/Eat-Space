package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFavourite


import com.google.gson.annotations.SerializedName

data class ViewFavouriteData(
    @SerializedName("favourite")
    val favourite: List<Favourite>
)