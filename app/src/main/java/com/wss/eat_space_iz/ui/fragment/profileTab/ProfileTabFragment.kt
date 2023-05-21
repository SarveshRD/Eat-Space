package com.wss.eat_space_iz.ui.fragment.profileTab

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.gson.Gson
import com.wss.eat_space_iz.data.networkModels.common.uploadImage.UploadImageResponse
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin.UserLoginData
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserResponse
import com.wss.eat_space_iz.databinding.FragmentProfileTabBinding
import com.wss.eat_space_iz.ui.activity.loginSignUp.LoginSignUpActivity
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.profileTab.ProfileTabViewModel
import com.wss.eat_space_iz.utils.*
import com.wss.eat_space_iz.utils.constants.AppConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File

@AndroidEntryPoint
class ProfileTabFragment :
    BaseFrag<FragmentProfileTabBinding, ProfileTabViewModel>(Layouts.fragment_profile_tab) {

    private var mUserId: String? = null
    private var mProfileUrl: String? = null
    private var mUserProfileDetails: String? = null
    private var mUserProfileData: UserLoginData? = null
    private lateinit var navController: NavController

    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentProfileTabBinding.inflate(layoutInflater)
    override val vm: ProfileTabViewModel by viewModels()

    override fun init() {
        navController = findNavController()
        mUserId = prefs.userId
        mUserProfileDetails = prefs.userProfileDetails
        mUserProfileData = Gson().fromJson(mUserProfileDetails, UserLoginData::class.java)
        setUpUserProfileData(mUserProfileData)
        setUpListener()
    }

    private fun setUpListener() {
        with(binding) {

            civProfileImgEdit.setOnClickListener(this@ProfileTabFragment)
            vProfileMyOrders.setOnClickListener(this@ProfileTabFragment)
            vMyAddresses.setOnClickListener(this@ProfileTabFragment)
            vPaymentMethods.setOnClickListener(this@ProfileTabFragment)
            vOffersDeals.setOnClickListener(this@ProfileTabFragment)
            vFavourites.setOnClickListener(this@ProfileTabFragment)
            vHelpSupport.setOnClickListener(this@ProfileTabFragment)
            vTermsCondition.setOnClickListener(this@ProfileTabFragment)
            vChangePassword.setOnClickListener(this@ProfileTabFragment)
            vLogout.setOnClickListener(this@ProfileTabFragment)
            ivEditProfile.setOnClickListener(this@ProfileTabFragment)
            vOffersDeals.setOnClickListener(this@ProfileTabFragment)

        }
    }

    private fun setUpUserProfileData(data: UserLoginData?) {
        with(binding) {
            if (data != null) {
                tvProfieName.text = data.fullName
                tvMobileEmail.text = buildString {
                    append(data.mobileNo)
                    append(" ")
                    append(data.email)
                }
                civProfile.load(prefs.userProfilePic) {
                    placeholder(Drawables.ic_placeholder)
                    error(Drawables.ic_placeholder)
                }
            }
        }
    }

    private fun uploadImage(file: File) {
        lifecycleScope.launch {
            file.compress(requireContext())
                ?.let { vm.uploadImage(it, AppConstants.App.PROFILE_IMAGE_FOLDER) }
        }
    }

    private fun upDateUserProfile() {
        when {
            mUserProfileData != null -> {
                with(mUserProfileData) {
                    mProfileUrl?.let { mProfileUrl ->
                        mUserProfileData?.id?.let {
                            val updateUserRequest = UpdateUserRequest(
                                userId = mUserProfileData!!.id,
                                profileStatus = this!!.profileStatus,
                                profilePic = mProfileUrl,
                                fullName = fullName,
                                mobileNo = mobileNo,
                                email = email,
                            )
                            vm.updateUser(updateUserRequest)
                        } ?: errorToast(getString(Strings.api_something_went_wrong))
                    } ?: errorToast(getString(Strings.api_something_went_wrong))
                }
            }
        }
    }


    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {
                when (apiRenderState.result) {
                    is UploadImageResponse -> {
                        val model = apiRenderState.result
                        model.status?.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    mProfileUrl = model.url
                                    prefs.userProfilePic = mProfileUrl
                                    upDateUserProfile()
                                }
                            }
                        }
                    }
                    is UpdateUserResponse -> {
                        val model = apiRenderState.result
                        model.status?.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    successToast("Profile Picture Updated Successfully")
                                }
                            }
                        }
                    }
                }


            }
            is ApiRenderState.ValidationError -> {
                apiRenderState.message?.let {
                    errorToast(getString(it))
                }
            }
            is ApiRenderState.ApiError<*> -> {
                errorToast(apiRenderState.error.toString())
            }
            else -> {}
        }
    }

    override fun getSelectedFile(file: File) {
        super.getSelectedFile(file)
        "SELECTED FILE PATH  ${file.path}".logE()
        binding.civProfile.load(file) {
            placeholder(Drawables.ic_placeholder)
            error(Drawables.ic_placeholder)
        }
        val filePath: String? = file.path
        if (!filePath.isNullOrEmpty()) {
            uploadImage(file)
        } else {
            errorToast(getString(Strings.error_camera_gallery_file_pick))
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding) {
            when (v) {
                vProfileMyOrders -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToMyOrdersFragment()
                    navController.navigate(action)
                }
                vChangePassword -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToChangePasswordFragment()
                    navController.navigate(action)
                }
                vFavourites -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToMyFavouriteFragment()
                    navController.navigate(action)
                }
                vMyAddresses -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToMyAddressesFragment()
                    navController.navigate(action)
                }
                civProfileImgEdit -> {
                    selectImage()
                }
                ivEditProfile -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToProfileEditFragment()
                    navController.navigate(action)
                }
                vOffersDeals -> {
                    val action =
                        ProfileTabFragmentDirections.actionProfileTabFragmentToDiscountCodeFragment()
                    navController.navigate(action)
                }

                vLogout -> {
                    logoutApp()
                }

                else -> {}
            }
        }
    }


    private fun logoutApp() {
        successToast("Logout App")
        Handler(Looper.getMainLooper()).postDelayed({
            prefs.clearPrefs()
            moveLoginIntent()
        }, 1000)
    }

    private fun moveLoginIntent() {
        val loginIntent = Intent(requireActivity(), LoginSignUpActivity::class.java)
        startActivity(loginIntent)
        requireActivity().finish()
    }


}