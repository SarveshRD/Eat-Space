package com.wss.eat_space_iz.data.networkModels.loginSignUp.createUserAccount


import com.google.gson.annotations.SerializedName

data class CreateUserAccountData(
    @SerializedName("email")
    var email: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("mobile_no")
    var mobileNo: String,
    @SerializedName("password")
    var password: String
)