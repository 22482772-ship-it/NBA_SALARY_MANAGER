package com.example.nba_salary_manager.data.model

import com.google.gson.annotations.SerializedName

// ── API Wrapper ──────────────────────────────────────────────

data class ApiResponse<T>(
    val data: List<T>,
    val meta: Meta? = null
)

data class Meta(
    @SerializedName("next_cursor") val nextCursor: Int? = null,
    @SerializedName("per_page") val perPage: Int? = null
)

// ── Team ─────────────────────────────────────────────────────

data class Team(
    val id: Int,
    val conference: String,
    val division: String,
    val city: String,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    val abbreviation: String
)

// ── Player ───────────────────────────────────────────────────

data class Player(
    val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val position: String?,
    val height: String?,
    val weight: String?,
    @SerializedName("jersey_number") val jerseyNumber: String?,
    val college: String?,
    val country: String?,
    @SerializedName("draft_year") val draftYear: Int?,
    @SerializedName("draft_round") val draftRound: Int?,
    @SerializedName("draft_number") val draftNumber: Int?,
    val team: Team?
)

// ── Game ─────────────────────────────────────────────────────

data class Game(
    val id: Int,
    val date: String,
    val season: Int,
    val status: String,
    val period: Int?,
    val time: String?,
    val postseason: Boolean,
    @SerializedName("home_team_score") val homeTeamScore: Int,
    @SerializedName("visitor_team_score") val visitorTeamScore: Int,
    @SerializedName("home_team") val homeTeam: Team,
    @SerializedName("visitor_team") val visitorTeam: Team
)

// ── Player Stats ─────────────────────────────────────────────

data class PlayerStats(
    val id: Int,
    val min: String?,
    val pts: Int?,
    val reb: Int?,
    val ast: Int?,
    val stl: Int?,
    val blk: Int?,
    val turnover: Int?,
    val pf: Int?,
    @SerializedName("fg_pct") val fgPct: Double?,
    @SerializedName("fg3_pct") val fg3Pct: Double?,
    @SerializedName("ft_pct") val ftPct: Double?,
    val fgm: Int?,
    val fga: Int?,
    val fg3m: Int?,
    val fg3a: Int?,
    val ftm: Int?,
    val fta: Int?,
    val oreb: Int?,
    val dreb: Int?,
    @SerializedName("plus_minus") val plusMinus: Int?,
    val player: Player?,
    val team: Team?,
    val game: Game?
)
