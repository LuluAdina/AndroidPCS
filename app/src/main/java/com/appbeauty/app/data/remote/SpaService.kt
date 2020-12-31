package com.appbeauty.app.data.remote

import com.appbeauty.app.data.model.SpaList
import retrofit2.Call
import retrofit2.http.GET

interface SpaService {
    @GET("http://makeup-api.herokuapp.com/api/v1/products.json")
    fun listSpa() : Call<SpaList>
}