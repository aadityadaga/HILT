package com.example.myapplication.data.remote

import com.example.myapplication.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getAllTeams(): Response<TeamResponse>
}
