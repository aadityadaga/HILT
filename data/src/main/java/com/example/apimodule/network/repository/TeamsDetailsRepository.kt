package com.example.apimodule.network.repository

import com.example.api.ApiInterface
import com.example.api.modelDTO.TeamResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsDetailsRepository @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getAllTeams(): Response<TeamResponse> {
        return apiInterface.getAllTeams()
    }
}