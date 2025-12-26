package com.example.myapplication.data.remote.network.repository

import com.example.myapplication.data.remote.ApiInterface
import com.example.myapplication.model.TeamResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsDetailsRepository @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getAllTeams(): Response<TeamResponse> {
        return apiInterface.getAllTeams()
    }
}