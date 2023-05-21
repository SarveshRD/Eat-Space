package com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory


import com.google.gson.annotations.SerializedName

data class ViewGlobalCategoryResponse(
    @SerializedName("message")
    val data: List<ViewGlobalCategoryData>,
    @SerializedName("status")
    val status: String
)