package com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin


import com.google.gson.annotations.SerializedName

data class UserLoginEmailRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)