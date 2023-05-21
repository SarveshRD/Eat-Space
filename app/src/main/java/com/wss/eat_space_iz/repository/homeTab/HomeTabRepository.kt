package com.wss.eat_space_iz.repository.homeTab

import com.wss.eat_space_iz.data.networkModels.homeTab.filterByGlobalCategories.ViewFilterByGlobalCategoriesResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory.ViewGlobalCategoryResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class HomeTabRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo(){


    suspend fun viewPopularNearYou(
        lat : String,
        long : String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewPopularNearYouResponse? {
        return with(apiCall(executable = {
            apiCall.viewPopularNearYou(lat = lat,long = long)
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

    suspend fun viewGlobalCategories(
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewGlobalCategoryResponse? {
        return with(apiCall(executable = {
            apiCall.viewGlobalCategory()
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

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



}