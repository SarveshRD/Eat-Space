package com.wss.eat_space_iz.repository.homeTab

import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class AllRestaurantListRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo(){
}