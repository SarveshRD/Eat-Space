package com.wss.eat_space_iz.data.networkModels.profileTab.addAddress


import com.google.gson.annotations.SerializedName

data class AddAddressResponse(
    @SerializedName("message")
    val data: AddAddressData,
    @SerializedName("status")
    val status: String
)