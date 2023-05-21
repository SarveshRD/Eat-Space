package com.wss.eat_space_iz.data.networkModels.profileTab.viewUserAddress


import com.google.gson.annotations.SerializedName

data class ViewUserAddressResponse(
    @SerializedName("message")
    var data: List<ViewUserAddressData>,
    @SerializedName("status")
    var status: String?
)