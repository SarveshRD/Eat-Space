package com.wss.eat_space_iz.data.networkModels.homeTab.filterByGlobalCategories


import com.google.gson.annotations.SerializedName

data class ViewFilterByGlobalCategoriesResponse(
    @SerializedName("message")
    val data: List<ViewFilterByGlobalCategoriesData>,
    @SerializedName("status")
    val status: String
)