package com.wss.eat_space_iz.data.networkModels.profileTab.applyOffer


import com.google.gson.annotations.SerializedName

data class ApplyOfferRequest(
    @SerializedName("promocode_id")
    val promocodeId: Int,
    @SerializedName("user_id")
    val userId: Int
)