package com.github.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Muscle(
    @BsonId var id: String,

    var name: String,

    var group: MuscleGroup
)