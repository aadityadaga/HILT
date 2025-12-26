package com.example.apimodule.network.modelDTO

import com.google.gson.annotations.SerializedName

data class Teams(

    @SerializedName("strTeam") var strTeam: String? = null,
    @SerializedName("strStadium") var strStadium: String? = null,
    @SerializedName("strLogo") var strLogo: String? = null,
)