package com.wss.eat_space_iz.repository.searchTab

import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou.TrendingNearYouResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class SearchTabRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo() {


    suspend fun viewRecommended(
        userId : String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): RecommendedForYouResponse? {
        return with(apiCall(executable = {
            apiCall.viewRecommendForYou(userId =userId)
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }


    suspend fun viewTrendingNearYou(
        lat:String,
        long:String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): TrendingNearYouResponse? {
        return with(apiCall(executable = {
            apiCall.viewTrendingNearYou(long = long, lat = lat)
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

}