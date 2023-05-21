package com.wss.eat_space_iz.ui.viewModel.searchTab


import com.wss.eat_space_iz.repository.searchTab.SearchTabRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchTabViewModel
@Inject constructor(private val repo: SearchTabRepository) : BaseVM(){


    fun viewRecommended(userId : String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewRecommended(userId,onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun viewTrendingNearYou(lat:String,long:String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewTrendingNearYou(lat,long,onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

}