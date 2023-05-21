package com.wss.eat_space_iz.ui.viewModel.profileTab


import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserRequest
import com.wss.eat_space_iz.repository.profileTab.ProfileTabRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileTabViewModel
@Inject constructor(private val repo: ProfileTabRepository) : BaseVM() {

    fun uploadImage(file: File, folderName: String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.uploadImage(
                file,
                folderName,
                onApiError
            )?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun updateUser(updateUserRequest: UpdateUserRequest) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.updateUser(updateUserRequest, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

}