package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.CustomTeamResponse
import com.example.data.state.DataHandler
import com.example.data.usecase.GetTeamsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getTeamsDetailUseCase: GetTeamsDetailUseCase) :
    ViewModel() {

    private val _teamsDetails =
        MutableStateFlow<DataHandler<CustomTeamResponse>>(DataHandler.Loading())
    val teamsDetails: StateFlow<DataHandler<CustomTeamResponse>> = _teamsDetails


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