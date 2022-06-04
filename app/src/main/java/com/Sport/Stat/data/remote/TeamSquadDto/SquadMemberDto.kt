package com.Sport.Stat.data.remote.TeamSquadDto

import com.Sport.Stat.common.Constants.na
import com.Sport.Stat.domain.model.SquadMember

data class SquadMemberDto(
    val birthdate: String?,
    val cc: String?,
    val foot: String?,
    val height: String?,
    val id: String?,
    val marketvalue: String?,
    val membersince: String?,
    val name: String?,
    val position: String?,
    val shirtnumber: String?,
    val weight: String?
)

fun SquadMemberDto.toSquad(): SquadMember {
    return SquadMember(
        birthdate = birthdate ?: na,
        cc = cc ?: na,
        foot = foot ?: na,
        height = height ?: na,
        id = id ?: na,
        marketValue = marketvalue ?: na,
        memberSince = membersince ?: na,
        name = name ?: na,
        position = position ?: na,
        shirtNumber = shirtnumber ?: na,
        weight = weight ?: na
    )
}