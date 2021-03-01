package com.github.models

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.sql.Date

@Serializable
data class UserExercise(
    @BsonId var id: String,

    @Contextual
    @JsonProperty("exercise_id")
    var exerciseId: ObjectId,

    @Contextual
    @JsonProperty("user_id")
    var userId: ObjectId,

    var repetitions: Int?,

    @Contextual
    @JsonProperty("seconds_time")
    var secondsTime: Int?
)