package com.wss.eat_space_iz.data.networkModels.cartTab.viewAdminOffers


import com.google.gson.annotations.SerializedName

data class ViewAdminOffersData(
    @SerializedName("coupon_limit")
    val couponLimit: Int,
    @SerializedName("discount_amount")
    val discountAmount: String,
    @SerializedName("discount_type")
    val discountType: String,
    @SerializedName("expiry_datetime")
    val expiryDatetime: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("max_discount_amount")
    val maxDiscountAmount: String,
    @SerializedName("max_usage_per_user")
    val maxUsagePerUser: Int,
    @SerializedName("promo_discription")
    val promoDiscription: String,
    @SerializedName("promo_img")
    val promoImg: String,
    @SerializedName("promocode")
    val promocode: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("total_usage")
    val totalUsage: Int,
    @SerializedName("user_count")
    val userCount: String
)