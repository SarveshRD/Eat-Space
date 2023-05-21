package com.wss.eat_space_iz.data.networkModels.loginSignUp.userResetPassword


import com.google.gson.annotations.SerializedName

data class UserResetPasswordRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)