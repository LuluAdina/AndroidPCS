package com.appbeauty.app.ui.spa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appbeauty.app.data.model.ActionState
import com.appbeauty.app.data.model.Spa
import com.appbeauty.app.data.repository.SpaRepository
import kotlinx.coroutines.launch

class SpaViewModel : ViewModel() {
    private val repo : SpaRepository by lazy {SpaRepository()}

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Spa>>()

    fun listSpa(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listSpa()
            actionState.value = resp
            loading.value = false
        }
    }
}