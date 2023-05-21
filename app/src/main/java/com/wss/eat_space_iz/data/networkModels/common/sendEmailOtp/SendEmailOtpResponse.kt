package com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp

import com.google.gson.annotations.SerializedName
import com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp.SendEmailOtpData

data class SendEmailOtpResponse(
    @SerializedName("message") val data: SendEmailOtpData,
    @SerializedName("status") val status: String
)