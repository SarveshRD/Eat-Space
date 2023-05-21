package com.wss.eat_space_iz.data.networkModels.profileTab.updateUser


import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
    @SerializedName("email")
    val email: String,
    /*@SerializedName("favourite")
    val favourite: List<Any>,*/
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("mobile_no")
    val mobileNo: String,
    @SerializedName("profile_pic")
    val profilePic: String,
    @SerializedName("profile_status")
    val profileStatus: Boolean,
    /*@SerializedName("reward_points")
    val rewardPoints: Int,*/
    @SerializedName("user_id")
    val userId: Int
)