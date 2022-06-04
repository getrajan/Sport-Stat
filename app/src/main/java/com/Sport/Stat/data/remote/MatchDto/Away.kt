package com.Sport.Stat.data.remote.MatchDto

import com.Sport.Stat.domain.model.AwayModel

data class Away(
    val cc: String,
    val id: String,
    val image_id: String,
    val name: String
)

fun Away.toAwayModel(): AwayModel {
    return AwayModel(
        cc = cc,
        id = id,
        imageId = image_id,
        name = name
    );
}