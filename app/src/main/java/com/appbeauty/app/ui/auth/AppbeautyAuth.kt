package com.appbeauty.app.ui.auth

import android.content.Context
import com.appbeauty.app.data.model.ActionState
import com.appbeauty.app.data.repository.AuthRepository
import kotlinx.coroutines.*

object AppbeautyAuth {

    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null){
        val repo = AuthRepository(context)
       CoroutineScope(Dispatchers.IO).launch {
           val resp = repo.logout()
           withContext(Dispatchers.Main){
               if (callback != null) callback.invoke(resp)
           }
       }
    }
}