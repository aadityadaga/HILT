package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apimodule.network.state.DataHandler
import com.example.apimodule.network.usecase.GetTeamsDetailUseCase
import com.example.data.model.TeamResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getTeamsDetailUseCase: GetTeamsDetailUseCase) :
    ViewModel() {

    private val _teamsDetails = MutableStateFlow<DataHandler<TeamResponse>>(DataHandler.Loading())
    val teamsDetails: StateFlow<DataHandler<TeamResponse>> = _teamsDetails


    init {
        fetchTeamsDetail()
    }
    fun fetchTeamsDetail() {
        viewModelScope.launch {
            _teamsDetails.value = DataHandler.Loading()
            _teamsDetails.value = getTeamsDetailUseCase.execute()
        }
    }
}