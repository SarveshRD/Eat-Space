package com.wss.eat_space_iz.network


import com.wss.eat_space_iz.data.networkModels.blogsTab.checkCampaignEligibility.CheckCampaignEligibilityResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.deleteBlogReview.DeleteBlogReviewResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.filterByGlobalCategories.ViewFilterByGlobalCategoriesResponse
import com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou.TrendingNearYouResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogRequest
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogResponse
import com.wss.eat_space_iz.data.networkModels.cartTab.viewAdminOffers.ViewAdminOffersResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllItemList.ViewAllItemListResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllNotification.ViewAllNotificationResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllUser.ViewAllUserResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewCards.ViewCardsResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFavourite.ViewFavouriteResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.ViewFollowingFollowerResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewRestaurantForBlog.ViewRestaurantForBlogResponce
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserProfile.ViewUserProfileResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserRewardPoint.ViewUserRewardPointResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview.WriteBlogReviewRequest
import com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview.WriteBlogReviewResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.viewUserAddress.ViewUserAddressResponse
import com.wss.eat_space_iz.data.networkModels.common.sendNotification.SendNotificationRequest
import com.wss.eat_space_iz.data.networkModels.common.sendNotification.SendNotificationResponse
import com.wss.eat_space_iz.data.networkModels.orderTab.orderScheduleLater.OrderScheduleLaterRequest
import com.wss.eat_space_iz.data.networkModels.orderTab.orderScheduleLater.OrderScheduleLaterResponse
import com.wss.eat_space_iz.data.networkModels.orderTab.readNotification.ReadNotificationRequest
import com.wss.eat_space_iz.data.networkModels.orderTab.readNotification.ReadNotificationResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.addAddress.AddAddressRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.addAddress.AddAddressResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.addCard.AddCardRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.addCard.AddCardResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.addFavourite.AddFavouriteRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.addFavourite.AddFavouriteResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.applyOffer.ApplyOfferRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.applyOffer.ApplyOfferResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.changePrimaryAddress.ChangePrimaryAddressRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.changePrimaryAddress.ChangePrimaryAddressResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.clearNotification.ClearNotificationResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.deleteCard.DeleteCardResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.followUser.FollowUserRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.followUser.FollowUserResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.removeFavourite.RemoveFavouriteRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.removeFavourite.RemoveFavouriteResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.updateCard.UpdateCardRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.updateCard.UpdateCardResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserResponse
import com.wss.eat_space_iz.utils.constants.AppConstants
import retrofit2.http.*

import com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp.SendEmailOtpRequest
import com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp.SendEmailOtpResponse
import com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp.SendMobileOtpRequest
import com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp.SendMobileOtpResponse
import com.wss.eat_space_iz.data.networkModels.common.uploadImage.UploadImageResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory.ViewGlobalCategoryResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouResponse
import com.wss.eat_space_iz.data.networkModels.loginSignUp.createUserAccount.CreateUserAccountRequest
import com.wss.eat_space_iz.data.networkModels.loginSignUp.createUserAccount.CreateUserAccountResponse
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin.UserLoginEmailRequest
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin.UserLoginMobileNoRequest
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin.UserLoginResponse
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userResetPassword.UserResetPasswordRequest
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userResetPassword.UserResetPasswordResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.changePassword.ChangePasswordRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.changePassword.ChangePasswordResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    //Common
    @Multipart
    @POST(AppConstants.Api.UserEndUrl.IMAGE_UPLOAD)
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("folder") folderName: RequestBody,
    ): UploadImageResponse

    @POST(AppConstants.Api.UserEndUrl.SEND_MOBILE_OTP)
    suspend fun sendMobileOtp(@Body sendMobileOtpRequest: SendMobileOtpRequest): SendMobileOtpResponse

    @POST(AppConstants.Api.UserEndUrl.SEND_EMAIL_OTP)
    suspend fun sendEmailOtp(@Body sendEmailOtpRequest: SendEmailOtpRequest): SendEmailOtpResponse

    //Login Sign Up Flow
    @POST(AppConstants.Api.UserEndUrl.USER_SIGN_UP)
    suspend fun userSignUp(@Body createUserAccountRequest: CreateUserAccountRequest): CreateUserAccountResponse

    @POST(AppConstants.Api.UserEndUrl.USER_LOGIN)
    suspend fun userEmailLogin(@Body userLoginEmailRequest: UserLoginEmailRequest): UserLoginResponse

    @POST(AppConstants.Api.UserEndUrl.USER_LOGIN)
    suspend fun userMobileNoLogin(@Body userLoginMobileNoRequest: UserLoginMobileNoRequest): UserLoginResponse

    @PUT(AppConstants.Api.UserEndUrl.USER_FORGOT_PASSWORD)
    suspend fun userPasswordReset(@Body userResetPasswordRequest: UserResetPasswordRequest): UserResetPasswordResponse


    //Delete

    @DELETE(AppConstants.Api.UserEndUrl.CLEAR_NOTIFICATION)
    suspend fun clearNotification(@Path("user_id") userId: String): ClearNotificationResponse

    @DELETE(AppConstants.Api.UserEndUrl.DELETE_BLOG_REVIEW)
    suspend fun deleteBlogReview(@Path("blog_id") blogId: String): DeleteBlogReviewResponse

    @DELETE(AppConstants.Api.UserEndUrl.DELETE_CARD)
    suspend fun deleteCard(@Path("card_id") cardId: String): DeleteCardResponse


    //Put Request

    @PUT(AppConstants.Api.UserEndUrl.PRIMARY_ADDRESS)
    suspend fun changePrimaryAddress(@Body changePrimaryAddressRequest: ChangePrimaryAddressRequest): ChangePrimaryAddressResponse

    @PUT(AppConstants.Api.UserEndUrl.READ_NOTIFCATION)
    suspend fun readNotification(@Body readNotificationRequest: ReadNotificationRequest): ReadNotificationResponse

    @PUT(AppConstants.Api.UserEndUrl.UPDATE_CARD)
    suspend fun updateCard(@Body updateCardRequest: UpdateCardRequest): UpdateCardResponse

    @PUT(AppConstants.Api.UserEndUrl.UPDATE_USER)
    suspend fun updateUser(@Body updateUserRequest: UpdateUserRequest): UpdateUserResponse

    @PUT(AppConstants.Api.UserEndUrl.CHANGE_PASSWORD)
    suspend fun changePassword(@Body changePasswordRequest: ChangePasswordRequest): ChangePasswordResponse

    //Post Request

    @POST(AppConstants.Api.UserEndUrl.BLOG_REVIEW)
    suspend fun writeBlogReview(@Body writeBlogReviewRequest: WriteBlogReviewRequest): WriteBlogReviewResponse

    @POST(AppConstants.Api.UserEndUrl.SEND_NOTIFICATION)
    suspend fun sendNotification(@Body sendNotificationRequest: SendNotificationRequest): SendNotificationResponse

    @POST(AppConstants.Api.UserEndUrl.ORDER_SCHEDULE_LATER)
    suspend fun orderScheduleLater(@Body orderScheduleLaterRequest: OrderScheduleLaterRequest): OrderScheduleLaterResponse

    @POST(AppConstants.Api.UserEndUrl.FOLLOW_USER)
    suspend fun followUser(@Body followUserRequest: FollowUserRequest): FollowUserResponse

    @POST(AppConstants.Api.UserEndUrl.APPLY_OFFER)
    suspend fun applyOffer(@Body applyOfferRequest: ApplyOfferRequest): ApplyOfferResponse

    @POST(AppConstants.Api.UserEndUrl.ADD_CARD)
    suspend fun addCard(@Body addCardRequest: AddCardRequest): AddCardResponse

    @POST(AppConstants.Api.UserEndUrl.ADD_ADDRESS)
    suspend fun addAddress(@Body addAddressRequest: AddAddressRequest): AddAddressResponse

    @POST(AppConstants.Api.UserEndUrl.ADD_FAVOURITE)
    suspend fun addFavourite(@Body addFavouriteRequest: AddFavouriteRequest): AddFavouriteResponse

    @POST(AppConstants.Api.UserEndUrl.REMOVE_FAVOURITE)
    suspend fun removeFavourite(@Body removeFavouriteRequest: RemoveFavouriteRequest): RemoveFavouriteResponse

    @POST(AppConstants.Api.UserEndUrl.REMOVE_UPVOTE)
    suspend fun removeUpvote(@Body removeUpvoteRequest: RemoveUpvoteRequest): RemoveUpvoteResponse

    @POST(AppConstants.Api.UserEndUrl.UPVOTE_BLOG)
    suspend fun upvoteBlog(@Body upvoteBlogRequest: UpvoteBlogRequest): UpvoteBlogResponse

    //Get Request
    @GET(AppConstants.Api.UserEndUrl.USER_REWARD_POINT)
    suspend fun viewUserRewardPoint(
        @Path("email") email: String,
    ): ViewUserRewardPointResponse

    @GET(AppConstants.Api.UserEndUrl.USER_PROFILE)
    suspend fun viewUserProfile(
        @Path("user_id") userId: String,
    ): ViewUserProfileResponse

    @GET(AppConstants.Api.UserEndUrl.USER_BLOG)
    suspend fun viewUserBlog(
        @Path("user_id") userId: String,
    ): ViewUserBlogResponse

    @GET(AppConstants.Api.UserEndUrl.USER_ADDRESS)
    suspend fun viewUserAddress(
        @Path("user_id") userId: String,
    ): ViewUserAddressResponse

    @GET(AppConstants.Api.UserEndUrl.RESTAURANT_FOR_BLOG)
    suspend fun viewRestaurantForBlog(
        @Path("user_id") userId: String,
    ): ViewRestaurantForBlogResponce

    @GET(AppConstants.Api.UserEndUrl.FOLLOWING_FOLLOWERS)
    suspend fun viewFollowingFollowers(
        @Path("user_id") userId: String,
    ): ViewFollowingFollowerResponse

    @GET(AppConstants.Api.UserEndUrl.VIEW_FAVOURITE)
    suspend fun viewFavourite(
        @Path("user_id") userId: String,
    ): ViewFavouriteResponse

    @GET(AppConstants.Api.UserEndUrl.VIEW_CARDS)
    suspend fun viewCards(
        @Path("user_id") userId: String,
    ): ViewCardsResponse

    @GET(AppConstants.Api.UserEndUrl.ALL_USER)
    suspend fun viewAllUser(): ViewAllUserResponse

    @GET(AppConstants.Api.UserEndUrl.ALL_ORDER)
    suspend fun viewAllOrder(
        @Path("user_id") userId: String,
    ): ViewAllOrderResponse

    @GET(AppConstants.Api.UserEndUrl.ALL_NOTIFICATION)
    suspend fun viewAllNotification(
        @Path("user_id") userId: String,
    ): ViewAllNotificationResponse

    @GET(AppConstants.Api.UserEndUrl.ADMIN_OFFERS)
    suspend fun viewAdminOffers(): ViewAdminOffersResponse

    @GET(AppConstants.Api.UserEndUrl.TRENDING_NEAR_YOU)
    suspend fun viewTrendingNearYou(
        @Query("longitude") long: String,
        @Query("latitude") lat: String,
    ): TrendingNearYouResponse

    @GET(AppConstants.Api.UserEndUrl.VIEW_GLOBAL_CATEGORY)
    suspend fun viewGlobalCategory(): ViewGlobalCategoryResponse

    @GET(AppConstants.Api.UserEndUrl.RECOMMEND_FOR_YOU)
    suspend fun viewRecommendForYou(
        @Path("user_id") userId: String,
    ): RecommendedForYouResponse

    @GET(AppConstants.Api.UserEndUrl.POPULAR_NEAR_YOU)
    suspend fun viewPopularNearYou(
        @Query("longitude") long: String,
        @Query("latitude") lat: String,
    ): ViewPopularNearYouResponse

    @GET(AppConstants.Api.UserEndUrl.FILTER_BY_GLOBAL_CATEGORIES)
    suspend fun viewFilterByGlobalCategories(
        @Path("global_cat_id") globalCatId: String,
        @Query("longitude") long: String,
        @Query("latitude") lat: String,
    ): ViewFilterByGlobalCategoriesResponse

    @GET(AppConstants.Api.UserEndUrl.CHECK_CAMPAIGN_ELIGIBILITY)
    suspend fun viewCheckCampaignEligibility(
        @Path("user_id") userId: String,
    ): CheckCampaignEligibilityResponse

    @GET(AppConstants.Api.UserEndUrl.ALL_ITEM_LIST)
    suspend fun viewAllItemList(): ViewAllItemListResponse

}