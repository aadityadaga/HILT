package com.example.myapplication.data.remote.usecase

import com.example.myapplication.data.remote.network.repository.TeamsDetailsRepository
import com.example.myapplication.model.TeamResponse
import com.example.myapplication.state.DataHandler
import javax.inject.Inject

class GetTeamsDetailUseCase @Inject constructor(
    private val teamsDetailsRepository: TeamsDetailsRepository
) {
    suspend fun execute(): DataHandler<TeamResponse> {
        return try {
            val response = teamsDetailsRepository.getAllTeams()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    DataHandler.Success(body)
                } else {
                    DataHandler.Error("Response body is empty")
                }
            } else {
                DataHandler.Error("Request failed with error code: ${response.code()}")
            }
        } catch (e: Exception) {
            DataHandler.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}
