package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("address_type")
    val addressType: String,
    @SerializedName("building_name")
    val buildingName: String,
    @SerializedName("city")
    val city: Int,
    @SerializedName("extra")
    val extra: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("landmark")
    val landmark: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("primary_address")
    val primaryAddress: Boolean,
    @SerializedName("user")
    val user: Int
)