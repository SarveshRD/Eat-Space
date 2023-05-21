package com.wss.eat_space_iz.data.networkModels.cartTab.viewUserAddress


import com.google.gson.annotations.SerializedName

data class ViewUserAddressResponse(
    @SerializedName("message")
    val data: List<Any>,
    @SerializedName("status")
    val status: String
)