package com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin


import com.google.gson.annotations.SerializedName

data class UserLoginData(
    @SerializedName("email")
    var email: String,
    @SerializedName("favourite")
    var favourite: List<Any>,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("mobile_no")
    var mobileNo: String,
    @SerializedName("profile_pic")
    var profilePic: String,
    @SerializedName("profile_status")
    var profileStatus: Boolean,
    @SerializedName("reward_points")
    var rewardPoints: Int
)