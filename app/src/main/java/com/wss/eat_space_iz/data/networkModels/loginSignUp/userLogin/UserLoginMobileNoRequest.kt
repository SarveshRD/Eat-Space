package com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin


import com.google.gson.annotations.SerializedName

data class UserLoginMobileNoRequest(
    @SerializedName("mobile_no")
    var mobileNo: String,
    @SerializedName("password")
    var password: String
)