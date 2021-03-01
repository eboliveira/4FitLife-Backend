package com.github.models

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Exercise(
    @BsonId var id: String,

    var name: String,

    var instructions: ArrayList<String>,

    @Contextual
    @JsonProperty("affected_muscles")
    var affectedMuscles: Array<AffectedMuscle>
)