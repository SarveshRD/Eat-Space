package com.wss.eat_space_iz.ui.fragment.profileTab

import android.graphics.Typeface
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.wss.eat_space_iz.R
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderData
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouData
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.databinding.FragmentMyOrdersBinding
import com.wss.eat_space_iz.ui.adapter.homeTab.recommended.RecommendedAdapter
import com.wss.eat_space_iz.ui.adapter.profileTab.myOrders.HistoryAdapter
import com.wss.eat_space_iz.ui.adapter.profileTab.myOrders.UpcomingAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.profileTab.MyOrdersViewModel
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.utils.Strings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyOrdersFragment :
    BaseFrag<FragmentMyOrdersBinding, MyOrdersViewModel>(Layouts.fragment_my_orders) {

    private lateinit var mUpcomingAdapter: UpcomingAdapter
    private lateinit var mUpcomingDataList: List<ViewAllOrderData>

    private lateinit var mHistoryAdapter: HistoryAdapter
    private lateinit var mHistoryDataList: List<ViewAllOrderData>

    private var userId:String = "4"

    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentMyOrdersBinding.inflate(layoutInflater)
    override val vm: MyOrdersViewModel by viewModels()

    override fun init() {
        setUpToolbar()
        setUpListener()
        viewUpcomingAndHistoryOrder(userId)
    }

    private fun viewUpcomingAndHistoryOrder(userId : String)
    {
        vm.viewAllOrder(userId)
    }
    private fun setUpListener() {
        with(binding) {

            tvUpcoming.setOnClickListener(this@MyOrdersFragment)
            tvHistory.setOnClickListener(this@MyOrdersFragment)
        }
    }

    private fun setUpToolbar() {
        with(binding.profileToolbar) {
            tvMyProfile.text = getText(Strings.profile_my_orders)
            imgBtnBack.setImageResource(Drawables.left_back_arrow_icon)
        }
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {

                when (apiRenderState.result) {

                    is ViewAllOrderResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {

                                    mUpcomingDataList = model.data.filter { it.orderStatus == "user_cancelled" }
                                    mHistoryDataList = model.data.filter { it.orderStatus == "restaurant_cancelled" }
                                    setupUpcomingRecyclerView(mUpcomingDataList)

                                }
                                else -> {}
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


    override fun onClick(v: View) {
        super.onClick(v)
        with(binding)
        {
            when (v) {

                tvUpcoming -> {
                    switchUpcoming()
                }
                tvHistory -> {
                    switchHistory()
                }

                else -> {}
            }
        }
    }


    private fun switchUpcoming() {
        with(binding) {
            rvHistory.visibility = View.GONE
            rvUpcoming.visibility = View.VISIBLE
            tvUpcoming.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.tv_follow_type_bg)
            tvHistory.background = null
            val typeface: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.gilroy_bold)
            tvUpcoming.typeface = typeface
            setupUpcomingRecyclerView(mUpcomingDataList)
          //  mMyBlogs = mOtherWall?.filter { blog -> blog.user != "02".toInt() }
            //mMyBlogs?.let { setUpMyBlogRecycler(it) }
        }
    }

    private fun switchHistory() {
        with(binding) {
            rvUpcoming.visibility = View.GONE
            rvHistory.visibility = View.VISIBLE
            tvHistory.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.tv_follow_type_bg)
            tvUpcoming.background = null
            val typeface: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.gilroy_bold)
            tvHistory.typeface = typeface
            setupHistoryRecycleView(mHistoryDataList)
          //  mMyBlogs = mOtherWall?.filter { blog -> blog.user != "02".toInt() }
          //  mMyBlogs?.let { setUpMyBlogRecycler(it) }
        }
    }

    private fun setupUpcomingRecyclerView(data: List<ViewAllOrderData>){
        mUpcomingDataList = data.filter { it.orderStatus == "user_cancelled" }
       // mUpcomingDataList = data
        if (mUpcomingDataList.isNotEmpty()) {
            mUpcomingAdapter = UpcomingAdapter(data)
            binding.rvUpcoming.adapter = mUpcomingAdapter
        }
    }

    private fun setupHistoryRecycleView(data: List<ViewAllOrderData>) {
        mHistoryDataList = data.filter { it.orderStatus == "restaurant_cancelled" }
     //   mHistoryDataList = data
        if (mHistoryDataList.isNotEmpty()) {
            mHistoryAdapter = HistoryAdapter(data)
            binding.rvHistory.adapter = mHistoryAdapter
        }
    }



}