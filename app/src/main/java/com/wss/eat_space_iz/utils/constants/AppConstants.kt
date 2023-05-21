package com.wss.eat_space_iz.utils.constants

class AppConstants {

    object App {

        const val ANDROID_IMAGE = "Android_img_file"
        const val PROFILE_IMAGE_FOLDER = "eat_profile_pic"
        const val MENU_IMAGE_FOLDER = "eat_menu"
        const val OTHER_IMAGE_FOLDER = "eat_images"

        const val PERMISSION_REQUEST_CODE = 1001
        const val IMAGE_CAMERA_CODE = 1002
        const val IMAGE_GALLERY_CODE = 1003

        const val ANDROID_LOG_A = "RideLogA"
        const val ANDROID_LOG_D = "RideLogD"
        const val ANDROID_LOG_E = "RideLogE"
        const val ANDROID_LOG_I = "RideLogI"
        const val ANDROID_LOG_V = "RideLogV"
        const val ANDROID_LOG_W = "RideLogW"

        object UserConstants {
            const val USER_HOME_TAB_RESULT_CODE = 2001
            const val USER_BOOKINGS_TAB_RESULT_CODE = 2002
            const val USER_SUPPORT_TAB_RESULT_CODE = 2003
            const val USER_PROFILE_TAB_RESULT_CODE = 2004
        }

    }

    object Prefs {

        object FirstTimeOnBoarding {
            const val Choose_a_Favourite_Food = "Choose_a_Favourite_Food"
            const val Receive_the_Great_Food = "Receive_the_Great_Food"
            const val Hot_Delivery_to_Home = "Hot_Delivery_to_Home"
        }

        object UserPrefs {
            const val IS_USER_LOGIN = "isUserLogin"
            const val USER_ID = "userId"
            const val USER_TOKEN = "userToken"
            const val USER_PROFILE_DETAILS = "userProfileDetails"
            const val USER_PROFILE_PIC = "userProfilePic"
            const val USER_HOME_LATE_LONG = "userHomeLateLong"
            const val USER_WORK_LATE_LONG = "userWorkLateLong"
            const val USER_CURRENT_LATE_LONG = "userCurrentLateLong"
            const val USER_SELECTED_PAYMENT_MODE = "userSelectedPaymentMethod"
            const val USER_EMAIL = "userEmail"
            const val USER_MOBILE_NO = "userMobileNo"
            const val USER_FULL_NAME = "userFullName"
        }

        object PaymentMode {
            const val CASH_MODE = "cash"
            const val SPACE_IZ_WALLET = "space-iz wallet"
            const val STRIPE_MODE = "strip payment"
        }
    }

    object Api {

        const val URL_TNC = "https://www.space-iz.com/terms-and-condition.html"
        const val URL_PRIVACY_POLICY = "https://www.space-iz.com/privacy-policy.html"
        const val IMAGE_UPLOAD = "/common/upload_img"

        object BaseUrl {

            /*const val BASE_URL =
                "http://ridespaceiz-env.eba-s3nm7qxp.eu-west-2.elasticbeanstalk.com"
            const val BASE_URL_2 = ""*/

            const val BASE_URL = "https://rideapi.space-iz.com/"

            //Chat Base URL
            const val CHAT_BASE_SOCKET_URL =
                "ws://ec2-13-41-201-135.eu-west-2.compute.amazonaws.com:8001/"
            const val CHAT_BASE_URL =
                "http://ec2-13-41-201-135.eu-west-2.compute.amazonaws.com:8001/"
            const val CHAT_HEADER = "token 0e01e3ecbf50299000b906907965649b41ebdb43"
            const val CHAT_BASE_URL_LOCATION =
                "wss://d2r4wvtyoh.execute-api.eu-west-2.amazonaws.com/production"
            const val MAP_BASE_URL = "https://maps.googleapis.com/maps/api/directions/json"


        }

        object UserEndUrl {

            //Common
            const val IMAGE_UPLOAD = "/account/upload_img"
            const val SEND_MOBILE_OTP = "/account/send-mobile-otp"
            const val SEND_EMAIL_OTP = "/account/send-email-otp"

            //BlogTab
            const val USER_REWARD_POINT = "/user/view-user-reward-point"
            const val BLOG_REVIEW = "/user/write-blog-review"
            const val USER_PROFILE = "/user/view-user-profile"
            const val USER_BLOG = "/user/view-user-blogs/{user_id}"
            const val USER_ADDRESS = "/user/view-user-address/{user_id}"
            const val RESTAURANT_FOR_BLOG = "/user/view-restaurant-for-blog"
            const val FOLLOWING_FOLLOWERS = "/user/view-following-followers/{user_id}"
            const val VIEW_FAVOURITE = "/user/view-favourite/{user_id}"
            const val VIEW_CARDS = "/user/view-cards"
            const val ALL_USER = "/user/view-all-user"
            const val ALL_ORDER = "/user/view-all-order/{user_id}"
            const val ALL_NOTIFICATION = "/user/view-all-notification"
            const val ADMIN_OFFERS = "/user/view-admin-offers"
            const val TRENDING_NEAR_YOU = "/user/trending-near-you"
            const val VIEW_GLOBAL_CATEGORY = "/account/view-global-category"
            const val RECOMMEND_FOR_YOU = "/user/recommend-for-you/{user_id}"
            const val POPULAR_NEAR_YOU = "/user/popular-near-you"
            const val FILTER_BY_GLOBAL_CATEGORIES = "/user/filter-by-global-categories/{global_cat_id}"
            const val CHECK_CAMPAIGN_ELIGIBILITY = "/user/check-campaign-eligibility"
            const val ALL_ITEM_LIST = "/user/all-item-list"
            const val SEND_NOTIFICATION = "/user/send-notification"
            const val ORDER_SCHEDULE_LATER = "/user/order-schedule-later"
            const val FOLLOW_USER = "/user/follow-user"
            const val APPLY_OFFER = "/user/apply-offer"
            const val ADD_CARD = "/user/add-card"
            const val ADD_ADDRESS = "/user/add-address"
            const val ADD_FAVOURITE = "/user/add-favourite"
            const val REMOVE_FAVOURITE = "/user/remove-favourite"
            const val REMOVE_UPVOTE = "/user/remove-upvote"
            const val UPVOTE_BLOG = "/user/upvote-blog"
            const val PRIMARY_ADDRESS = "/user/change-primary-address"
            const val READ_NOTIFCATION = "/user/read-notification"
            const val UPDATE_CARD = "/user/update-card"
            const val UPDATE_USER = "/user/update-user"
            const val CLEAR_NOTIFICATION = "/user/clear-notification/{user_id}"
            const val DELETE_BLOG_REVIEW = "/user/delete-blog-review/{blog_id}"
            const val DELETE_CARD = "/user/delete-card/{card_id}"
            const val CHANGE_PASSWORD = "/user/update-password"


            // User Entry
            const val USER_LOGIN = "/user/user-login"
            const val IS_USER_EXIST = "/user/is-user-exist"
            const val USER_SIGN_UP = "/user/create-user"
            const val USER_FORGOT_PASSWORD = "/user/reset-password"
            const val UPLOAD_DEVICE_TOKEN = "/user/user-update-device-token"

            //User Profile
            const val EDIT_USER_PROFILE = "/user/edit-user-profile"
            const val USER_RIDE_HISTORY = "/user/view-all-ride/{id}"
            const val EDIT_DRIVER_RATING = "/user/edit-driver-rating"
            const val VIEW_HISTORY_MESSAGE = "view-messages/"

            //Home
            const val VIEW_NEARBY_DRIVERS = "/user/view-nearby-drivers"
            const val PLACES_NEAR_BY_YOU = "/user/view-nearby-places"
            const val NEAR_BY_YOU_FILTERS = "/user/filter-keys/{category_type}"

            const val PICK_YOUR_RIDE = "/common/view-vehicle-type"
            const val TRIP_DRIVER_PROFILE = "/user/view-trip-driver-profile/{id}"
            const val USER_CANCEL_RIDE = "/user/cancel-ride"
            const val SEARCH_DRIVER = "/user/search-driver"
            const val CONFIRM_RIDE = "/user/confirm-ride"
            const val SCHEDULE_RIDE = "user/schedule-trip"
            const val USER_RIDE_STATE = "/user/user-state/{user_id}"
            const val USER_ON_GOING_RIDE = "/user/view-ongoing-ride/{user_id}"
            const val ADD_HOME = "/user/add-home"
            const val ADD_WORK = "/user/add-work"
            const val RECENT_DESTINATIONS = "/user/view-recent-destinations/{id}"
            const val ADD_DRIVER_RATING = "/user/add-driver-rating"

            //BookMarks
            const val USER_BOOKMARKS = "/user/view-bookmarks/{id}"
            const val USER_ADD_BOOKMARKS = "/user/add-bookmark"
            const val USER_REMOVE_BOOKMARKS = "/user/remove-bookmark/{id}"

            //Delete User Account
            const val VALIDATE_USER = "/common/validate-user"
            const val DELETE_USER_ACCOUNT = "/common/user-delete-request"

            const val EPHEMERAL_KEY = "get/payment-key"
            const val CREATE_CUSTOMER = "/user/create-customer"
            const val PAYMENT_SHEET = "/user/payment-sheet"
            const val USER_PAYMENT = "/user/payment"

        }

    }

    object StripeConstant {
        var PUBLISHABLE_KEY =
            "pk_test_51LuSnVIaAzvPoKkYBKrupkYDlo0WG11rNZJy3cWihYuDGp6G0EOPuhnhDuhMWtXynNLFulTdLSQC5aFbGekwdeBW008KWI6qqw"
    }


}