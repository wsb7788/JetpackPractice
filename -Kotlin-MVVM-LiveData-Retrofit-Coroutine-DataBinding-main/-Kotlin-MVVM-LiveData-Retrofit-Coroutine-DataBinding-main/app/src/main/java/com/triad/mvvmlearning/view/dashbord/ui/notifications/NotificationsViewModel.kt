package com.triad.mvvmlearning.view.dashbord.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triad.mvvmlearning.network.Resource
import com.triad.mvvmlearning.repository.LoginRepository
import com.triad.mvvmlearning.repository.NotificationRepository
import com.triad.mvvmlearning.responses.loginresponse.LoginResponse
import com.triad.mvvmlearning.responses.loginresponse.SavedFeedbackResponse
import kotlinx.coroutines.launch

class NotificationsViewModel(
    private var repository: NotificationRepository) : ViewModel() {

//    private val _loginResponse: MutableLiveData<Resource<Array<LoginResponse>>> = MutableLiveData()
//
//    val loginResponse: LiveData<Resource<Array<LoginResponse>>>
//        get() = _loginResponse

    fun login(body: HashMap<String,String>) = viewModelScope.launch {
        _apiResponse.value = repository.login(body)
    }


    private val _apiResponse: MutableLiveData<SavedFeedbackResponse>
            = MutableLiveData<SavedFeedbackResponse>().apply { value?.data  = emptyList() }

    val apiResponse: LiveData<SavedFeedbackResponse> get() = _apiResponse




}