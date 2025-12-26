package com.example.apimodule.network.repository

import com.example.api.ApiInterface
import com.example.apimodule.network.mapper.TeamsMapper
import com.example.data.model.CustomTeamResponse
import com.example.data.repository.TeamsRepository
import com.example.data.state.DataHandler
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(
    private val api: ApiInterface
) : TeamsRepository {
    override suspend fun getAllTeams(): DataHandler<CustomTeamResponse> {
        val response = api.getAllTeams()

        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                DataHandler.Success(TeamsMapper.mapToDomain(body))
            } else {
                DataHandler.Error("Response body is empty")
            }
        } else {
            DataHandler.Error("Request failed with error code: ${response.code()}")
        }

    }
}
