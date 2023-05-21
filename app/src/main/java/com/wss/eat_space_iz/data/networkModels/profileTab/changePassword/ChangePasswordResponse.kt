package com.wss.eat_space_iz.data.networkModels.profileTab.changePassword


import com.google.gson.annotations.SerializedName

data class ChangePasswordResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: String
)