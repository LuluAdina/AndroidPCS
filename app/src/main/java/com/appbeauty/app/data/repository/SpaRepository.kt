package com.appbeauty.app.data.repository

import com.appbeauty.app.data.model.ActionState
import com.appbeauty.app.data.model.Spa
import com.appbeauty.app.data.remote.RetrofitApi
import com.appbeauty.app.data.remote.SpaService
import retrofit2.await

class SpaRepository {

    private val spaservice : SpaService by lazy { RetrofitApi.spaService() }

    suspend fun listSpa() : ActionState<List<Spa>> {
        return try {
            val list = spaservice.listSpa().await()
            ActionState(list.data)
        } catch (e : Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}