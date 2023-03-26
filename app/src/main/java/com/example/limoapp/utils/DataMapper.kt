package com.example.limoapp.utils

import com.example.limoapp.data.local.entity.MomentEntity
import com.example.limoapp.domain.model.DataModel

object DataMapper {
    fun mapDomainToEntity(input: DataModel) = MomentEntity(
        id = input.id,
        comment = input.comment,
        path = input.path,
        time = input.time,
        emoji = input.emoji
    )

    fun mapEntitiesToDomain(input: List<MomentEntity>): List<DataModel> =
        input.map {
            DataModel(
                id = it.id,
                comment = it.comment,
                path = it.path,
                time = it.time,
                emoji = it.emoji
            )
        }
}