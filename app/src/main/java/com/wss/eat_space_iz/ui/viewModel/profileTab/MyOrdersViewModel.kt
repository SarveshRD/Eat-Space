package com.wss.eat_space_iz.ui.viewModel.profileTab


import com.wss.eat_space_iz.repository.profileTab.MyOrdersRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyOrdersViewModel
@Inject constructor(private val repo: MyOrdersRepository) : BaseVM(){


    fun viewAllOrder(userId : String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewAllOrder(userId,onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }




}