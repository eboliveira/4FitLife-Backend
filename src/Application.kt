package com.github

import com.github.models.Exercise
import com.github.mongo.ExerciseRepository
import com.github.mongo.MongoInterface
import com.github.mongo.UserExerciseRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import org.bson.types.ObjectId
import java.lang.Exception
import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    MongoInterface.initialize()

    install(ContentNegotiation) {
        gson { }
    }

    routing {
        get("/day") {
            val userId = call.request.queryParameters["userId"]
                ?: return@get call.respond(HttpStatusCode.BadRequest, "userId not received")
            val date = call.request.queryParameters["date"]
                ?: return@get call.respond(HttpStatusCode.BadRequest, "date not received")
            val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
            val localizedDate: Date
            try {
                localizedDate = Date.valueOf(LocalDate.parse(date, formatter))
            } catch (_e: Exception) {
                return@get call.respond(HttpStatusCode.BadRequest, "invalid date format")
            }
            val exerciseIds = UserExerciseRepository
                .getByUserIdForDay(ObjectId(userId), localizedDate)?.map { userExercise ->
                    userExercise.exerciseId
                }
            if (exerciseIds == null || exerciseIds.count() == 0) {
                return@get call.respond(arrayOf<Exercise>())
            }
            val exercises = ExerciseRepository.getExerciseByIds(exerciseIds.toList())

            call.respond(exercises?.toList() ?: arrayListOf())
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

