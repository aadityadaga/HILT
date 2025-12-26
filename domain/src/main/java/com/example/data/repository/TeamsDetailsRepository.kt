package com.example.data.repository

import com.example.data.ApiInterface
import com.example.data.model.TeamResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsDetailsRepository @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getAllTeams(): Response<TeamResponse> {
        return apiInterface.getAllTeams()
    }
}