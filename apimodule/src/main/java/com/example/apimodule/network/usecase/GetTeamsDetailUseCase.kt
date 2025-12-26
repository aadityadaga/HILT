package com.example.apimodule.network.usecase


import com.example.apimodule.network.repository.TeamsDetailsRepository
import com.example.apimodule.network.state.DataHandler
import com.example.data.model.TeamResponse
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
