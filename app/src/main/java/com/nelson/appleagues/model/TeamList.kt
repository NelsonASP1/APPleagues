package com.nelson.appleagues.model

import com.nelson.appleagues.Team
import com.google.gson.annotations.SerializedName

data class TeamList(@SerializedName("teams") val mList: List<Team>)
