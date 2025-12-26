package com.example.apimodule.network

import com.example.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getAllTeams(): Response<TeamResponse>
}
