package com.wss.eat_space_iz.data.networkModels.blogsTab.viewCards


import com.google.gson.annotations.SerializedName

data class ViewCardsResponse(
    @SerializedName("message")
    val data: List<Any>,
    @SerializedName("status")
    val status: String
)