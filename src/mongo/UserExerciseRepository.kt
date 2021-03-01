package com.github.mongo

import com.github.models.UserExercise
import com.mongodb.client.FindIterable
import com.mongodb.client.model.Filters.eq
import org.bson.types.ObjectId
import org.litote.kmongo.find
import java.util.*

class UserExerciseRepository {
    companion object {
        private const val collectionName = "user_exercise"
        private val collection = MongoInterface.database.getCollection(collectionName, UserExercise::class.java)

        fun getByUserIdForDay(id: ObjectId, day: Date): FindIterable<UserExercise>? {
            return collection.find(eq("user_id", id), eq("date", day))
        }
    }
}