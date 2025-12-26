package com.example.apimodule.network.mapper

import com.example.api.modelDTO.TeamResponse
import com.example.data.model.CustomTeamResponse
import com.example.data.model.CustomTeams

object TeamsMapper {

    fun mapToDomain(teamResponse: TeamResponse): CustomTeamResponse {
        return CustomTeamResponse(
            teams = teamResponse.teams.map { teamDto ->
                CustomTeams(
                    strTeam = teamDto.strTeam.orEmpty(),
                    strStadium = teamDto.strStadium.orEmpty(),
                    strLogo = teamDto.strLogo.orEmpty()
                )
            } as ArrayList<CustomTeams>
        )
    }
}