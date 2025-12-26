package com.example.data.repository

import com.example.data.model.CustomTeamResponse
import com.example.data.state.DataHandler

interface TeamsRepository {
    suspend fun getAllTeams(): DataHandler<CustomTeamResponse>
}