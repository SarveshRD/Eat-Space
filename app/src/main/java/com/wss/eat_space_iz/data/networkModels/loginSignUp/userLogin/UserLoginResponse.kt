package com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin


import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("message")
    var data: UserLoginData,
    @SerializedName("status")
    var status: String,
    @SerializedName("token")
    var token: String
)