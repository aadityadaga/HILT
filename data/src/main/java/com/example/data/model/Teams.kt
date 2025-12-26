package com.example.data.model


data class Teams(

    @SerializedName("strTeam") var strTeam: String? = null,
    @SerializedName("strStadium") var strStadium: String? = null,
    @SerializedName("strLogo") var strLogo: String? = null,
)