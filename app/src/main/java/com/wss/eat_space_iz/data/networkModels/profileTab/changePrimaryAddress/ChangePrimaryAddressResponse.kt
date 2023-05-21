package com.wss.eat_space_iz.data.networkModels.profileTab.changePrimaryAddress


import com.google.gson.annotations.SerializedName

data class ChangePrimaryAddressResponse(
    @SerializedName("message")
    val data: ChangePrimaryAddressData,
    @SerializedName("status")
    val status: String
)