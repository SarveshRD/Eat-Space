package com.wss.eat_space_iz.data.networkModels.profileTab.changePrimaryAddress


import com.google.gson.annotations.SerializedName

data class ChangePrimaryAddressRequest(
    @SerializedName("address_id")
    val addressId: Int
)