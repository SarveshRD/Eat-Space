package com.wss.eat_space_iz.data.networkModels.loginSignUp.createUserAccount


import com.google.gson.annotations.SerializedName

data class CreateUserAccountRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("mobile_no")
    var mobileNo: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("country_code")
    var countryCode: String,
    @SerializedName("profile_pic")
    var profilePic: String,
    @SerializedName("profile_status")
    var profileStatus: Boolean,
)