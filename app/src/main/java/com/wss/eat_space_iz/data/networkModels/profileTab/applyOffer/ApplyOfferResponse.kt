package com.wss.eat_space_iz.data.networkModels.profileTab.applyOffer


import com.google.gson.annotations.SerializedName

data class ApplyOfferResponse(
    @SerializedName("message")
    val data: ApplyOfferData,
    @SerializedName("status")
    val status: String
)