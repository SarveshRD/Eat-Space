package com.wss.eat_space_iz.data.networkModels.profileTab.changePassword


import com.google.gson.annotations.SerializedName

data class ChangePasswordRequest(
    @SerializedName("current_password")
    var currentPassword: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("user_id")
    var userId: Int
)