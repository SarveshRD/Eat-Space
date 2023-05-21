package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllUser


import com.google.gson.annotations.SerializedName

data class ViewAllUserData(
    @SerializedName("email")
    val email: String,
    @SerializedName("favourite")
    val favourite: List<Int>,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("mobile_no")
    val mobileNo: String,
    @SerializedName("profile_pic")
    val profilePic: String,
    @SerializedName("profile_status")
    val profileStatus: Boolean,
    @SerializedName("reward_points")
    val rewardPoints: Int
)