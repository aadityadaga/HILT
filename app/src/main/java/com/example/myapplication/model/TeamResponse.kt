package com.example.myapplication.model

import com.google.gson.annotations.SerializedName


data class TeamResponse(

    @SerializedName("teams") var teams: ArrayList<Teams> = arrayListOf()

)