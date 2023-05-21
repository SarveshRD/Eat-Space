package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder


import com.google.gson.annotations.SerializedName

data class ViewAllOrderData(
    @SerializedName("actual_delivery_time")
    val actualDeliveryTime: Any,
    @SerializedName("actual_prepared_time")
    val actualPreparedTime: Any,
    @SerializedName("address")
    val address: Address,
    @SerializedName("cancelled_reason")
    val cancelledReason: Any,
    @SerializedName("date")
    val date: String,
    @SerializedName("delivery_mobile_no")
    val deliveryMobileNo: Any,
    @SerializedName("delivery_pay")
    val deliveryPay: String,
    @SerializedName("delivery_profile")
    val deliveryProfile: Any,
    @SerializedName("discount")
    val discount: String,
    @SerializedName("driver_name")
    val driverName: Any,
    @SerializedName("eat_amount")
    val eatAmount: String,
    @SerializedName("estimate_delivery_time")
    val estimateDeliveryTime: Any,
    @SerializedName("estimate_preparing_time")
    val estimatePreparingTime: Any,
    @SerializedName("extra_notes")
    val extraNotes: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("item_total")
    val itemTotal: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("order_accepted_time")
    val orderAcceptedTime: Any,
    @SerializedName("order_place_time")
    val orderPlaceTime: String,
    @SerializedName("order_status")
    val orderStatus: String,
    @SerializedName("otp")
    val otp: Int,
    @SerializedName("promo_code")
    val promoCode: Any,
    @SerializedName("restaurant")
    val restaurant: Int,
    @SerializedName("restaurant_amount")
    val restaurantAmount: String,
    @SerializedName("restaurant_latitude")
    val restaurantLatitude: String,
    @SerializedName("restaurant_logo")
    val restaurantLogo: String,
    @SerializedName("restaurant_longitude")
    val restaurantLongitude: String,
    @SerializedName("restaurant_mobile_no")
    val restaurantMobileNo: String,
    @SerializedName("restaurant_name")
    val restaurantName: String,
    @SerializedName("tax")
    val tax: String,
    @SerializedName("total")
    val total: String,
    @SerializedName("trip_distance")
    val tripDistance: String,
    @SerializedName("txn_id")
    val txnId: String,
    @SerializedName("user")
    val user: Int,
    @SerializedName("user_mobile_no")
    val userMobileNo: String,
    @SerializedName("user_name")
    val userName: String
)