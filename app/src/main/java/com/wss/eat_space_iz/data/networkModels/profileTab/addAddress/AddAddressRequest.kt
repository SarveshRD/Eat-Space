package com.wss.eat_space_iz.data.networkModels.profileTab.addAddress


import com.google.gson.annotations.SerializedName

data class AddAddressRequest(
    @SerializedName("address_type")
    val addressType: String,
    @SerializedName("building_name")
    val buildingName: String,
    @SerializedName("city")
    val city: Int,
    @SerializedName("extra")
    val extra: String,
    @SerializedName("landmark")
    val landmark: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("user")
    val user: Int
)