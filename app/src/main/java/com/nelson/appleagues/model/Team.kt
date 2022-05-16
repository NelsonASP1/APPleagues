package com.nelson.appleagues

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("strTeam") val team: String,
    @SerializedName("strAlternate") val alternate: String,
    @SerializedName("strTeamBadge") val logo: String,
    val idTeam: String,
    @SerializedName("strSport") val sport: String,
    @SerializedName("strStadiumThumb") val logoStadiumThumb: String,
    @SerializedName("strStadium") val stadium: String,
    @SerializedName("strDescriptionES") val description: String,
    @SerializedName("strTeamJersey") val logoTeamJersey: String
)
