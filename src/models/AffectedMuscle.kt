package com.github.models

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class AffectedMuscle(
    var intensity: Double,

    var muscle: Muscle
)