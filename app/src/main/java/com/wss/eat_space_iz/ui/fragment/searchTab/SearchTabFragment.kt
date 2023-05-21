package com.wss.eat_space_iz.ui.fragment.searchTab

import android.view.View
import androidx.fragment.app.viewModels
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouData
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou.TrendingNearYouData
import com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou.TrendingNearYouResponse
import com.wss.eat_space_iz.databinding.FragmentSearchTabBinding
import com.wss.eat_space_iz.ui.adapter.homeTab.recommended.RecommendedAdapter
import com.wss.eat_space_iz.ui.adapter.searchTab.RecentSearchAdapter
import com.wss.eat_space_iz.ui.adapter.searchTab.TrendingNearYouAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.searchTab.SearchTabViewModel
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.utils.Strings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchTabFragment : BaseFrag<FragmentSearchTabBinding, SearchTabViewModel>(Layouts.fragment_search_tab)
{

    private lateinit var mRecommendedAdapter: RecommendedAdapter
    private lateinit var mRecommendedDataList: List<RecommendedForYouData>

    private lateinit var mTrendingNearYouAdapter : TrendingNearYouAdapter
    private lateinit var mTrendingNearYouDataList : List<TrendingNearYouData>

    private lateinit var mRecentSearchAdapter : RecentSearchAdapter
    private lateinit var mRecentSearchDataList : List<TrendingNearYouData>


    override val hasProgress: Boolean = false
    override fun getViewBinding() =  FragmentSearchTabBinding.inflate(layoutInflater)
    override val vm: SearchTabViewModel by viewModels()

    private var userId:String = "4"
    private var lat:String ="51.50998"
    private var long:String ="-0.1337"

    override fun init() {
        setUpListener()
        viewRecommended(userId)
        viewTrendingNearYou(lat,long)

    }

    private fun setUpListener() {
        with(binding) {

        }
    }

    private fun viewRecommended(userId:String)
    {
        vm.viewRecommended(userId)
    }
    private fun viewTrendingNearYou(lat:String,long:String)
    {
        vm.viewTrendingNearYou(lat,long)
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {

                when (apiRenderState.result) {

                    is RecommendedForYouResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    setupRecommendedRecyclerView(model.data)
                                }
                                else -> {}
                            }
                        }
                    }

                    is TrendingNearYouResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    setupTrendingRecyclerView(model.data)
                                    setupRecentSearchRecycleView(model.data)
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
            when (v)
            {

            }
        }
    }

    private fun setupRecommendedRecyclerView(data: List<RecommendedForYouData>){
        mRecommendedDataList = data
        if (mRecommendedDataList.isNotEmpty()) {
            mRecommendedAdapter = RecommendedAdapter(data)
            binding.homeRecommended.rvRecommended.adapter = mRecommendedAdapter
        }
    }

    private fun setupTrendingRecyclerView(data: List<TrendingNearYouData>){
        mTrendingNearYouDataList = data
        if (mTrendingNearYouDataList.isNotEmpty()) {
            mTrendingNearYouAdapter = TrendingNearYouAdapter(data)
            binding.rvTrendingNearYou.adapter = mTrendingNearYouAdapter
        }
    }

    private fun setupRecentSearchRecycleView(data: List<TrendingNearYouData>){
        mRecentSearchDataList = data
        if (mRecentSearchDataList.isNotEmpty()) {
            mRecentSearchAdapter = RecentSearchAdapter(data)
            binding.rvSearchSuggestion.adapter = mRecentSearchAdapter
        }
    }


}