package com.example.api.modelDTO

import com.example.apimodule.network.modelDTO.Teams
import com.google.gson.annotations.SerializedName


data class TeamResponse(

    @SerializedName("teams") var teams: ArrayList<Teams> = arrayListOf()

)