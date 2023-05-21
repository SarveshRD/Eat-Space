package com.wss.eat_space_iz.data.networkModels.loginSignUp.userResetPassword


import com.google.gson.annotations.SerializedName

data class UserResetPasswordResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: String
)