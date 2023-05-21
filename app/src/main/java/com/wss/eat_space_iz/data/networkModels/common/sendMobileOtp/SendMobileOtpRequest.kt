package com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp

import com.google.gson.annotations.SerializedName

data class SendMobileOtpRequest(
    @SerializedName("mobile_no") val mobileNo: String
)