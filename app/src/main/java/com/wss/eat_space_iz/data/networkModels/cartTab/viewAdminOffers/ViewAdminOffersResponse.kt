package com.wss.eat_space_iz.data.networkModels.cartTab.viewAdminOffers


import com.google.gson.annotations.SerializedName

data class ViewAdminOffersResponse(
    @SerializedName("message")
    val data: List<ViewAdminOffersData>,
    @SerializedName("status")
    val status: String
)