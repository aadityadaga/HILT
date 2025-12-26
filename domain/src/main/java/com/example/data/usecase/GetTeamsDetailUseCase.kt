package com.example.data.usecase


import com.example.data.model.CustomTeamResponse
import com.example.data.repository.TeamsRepository
import com.example.data.state.DataHandler
import javax.inject.Inject

class GetTeamsDetailUseCase @Inject constructor(
    private val teamsRepository: TeamsRepository
) {
    suspend operator fun invoke(): DataHandler<CustomTeamResponse> {
        return teamsRepository.getAllTeams()
    }
}
