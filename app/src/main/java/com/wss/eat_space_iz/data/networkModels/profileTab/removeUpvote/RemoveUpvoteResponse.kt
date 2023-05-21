package com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote


import com.google.gson.annotations.SerializedName

data class RemoveUpvoteResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)