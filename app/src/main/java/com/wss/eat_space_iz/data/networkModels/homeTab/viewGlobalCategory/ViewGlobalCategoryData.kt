package com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory


import com.google.gson.annotations.SerializedName

data class ViewGlobalCategoryData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String
)