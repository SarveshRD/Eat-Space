package com.wss.eat_space_iz.data.networkModels.profileTab.viewUserAddress


import com.google.gson.annotations.SerializedName

data class ViewUserAddressData(
    @SerializedName("address_type")
    var addressType: String,
    @SerializedName("building_name")
    var buildingName: String,
    @SerializedName("city")
    var city: Int,
    @SerializedName("extra")
    var extra: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("landmark")
    var landmark: String,
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("longitude")
    var longitude: String,
    @SerializedName("primary_address")
    var primaryAddress: Boolean,
    @SerializedName("user")
    var user: Int
)