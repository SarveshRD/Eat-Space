package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserRewardPoint


import com.google.gson.annotations.SerializedName

data class ViewUserRewardPointData(
    @SerializedName("reward_points")
    val rewardPoints: Int
)