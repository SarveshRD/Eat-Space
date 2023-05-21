package com.wss.eat_space_iz.data.networkModels.blogsTab.checkCampaignEligibility


import com.google.gson.annotations.SerializedName

data class CheckCampaignEligibilityResponse(
    @SerializedName("message")
    val data: Boolean,
    @SerializedName("status")
    val status: String
)