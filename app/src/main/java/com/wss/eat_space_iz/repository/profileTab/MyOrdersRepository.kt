package com.wss.eat_space_iz.repository.profileTab

import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class MyOrdersRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo() {

    suspend fun viewAllOrder(
        userId : String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewAllOrderResponse? {
        return with(apiCall(executable = {
            apiCall.viewAllOrder(userId = userId)
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

}