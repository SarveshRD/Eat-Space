package com.wss.eat_space_iz.data.networkModels.homeTab.filterByGlobalCategories


import com.google.gson.annotations.SerializedName

data class ViewFilterByGlobalCategoriesData(
    @SerializedName("accepting_order")
    val acceptingOrder: Boolean,
    @SerializedName("area")
    val area: String,
    @SerializedName("business_license")
    val businessLicense: String,
    @SerializedName("city")
    val city: Int,
    @SerializedName("close_at")
    val closeAt: String,
    @SerializedName("daily_target")
    val dailyTarget: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("door_no")
    val doorNo: String,
    @SerializedName("fri")
    val fri: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("mon")
    val mon: Boolean,
    @SerializedName("monthly_target")
    val monthlyTarget: String,
    @SerializedName("open_at")
    val openAt: String,
    @SerializedName("pincode")
    val pincode: String,
    @SerializedName("profile")
    val profile: Int,
    @SerializedName("profile_status")
    val profileStatus: Boolean,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("restaurant_name")
    val restaurantName: String,
    @SerializedName("reward_points")
    val rewardPoints: Int,
    @SerializedName("sat")
    val sat: Boolean,
    @SerializedName("sun")
    val sun: Boolean,
    @SerializedName("thu")
    val thu: Boolean,
    @SerializedName("tue")
    val tue: Boolean,
    @SerializedName("type_of_cuisine")
    val typeOfCuisine: Int,
    @SerializedName("wed")
    val wed: Boolean,
    @SerializedName("weekly_target")
    val weeklyTarget: String,
    @SerializedName("yearly_target")
    val yearlyTarget: String,
    @SerializedName("zone")
    val zone: Int
)