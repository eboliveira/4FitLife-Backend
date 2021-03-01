package com.github.mongo

import com.github.models.Exercise
import com.mongodb.client.FindIterable
import com.mongodb.client.model.Filters.`in`
import org.bson.types.ObjectId

class ExerciseRepository {
    companion object {
        private const val collectionName = "exercises"
        private val collection = MongoInterface.database.getCollection(collectionName, Exercise::class.java)

        fun getExerciseByIds(ids: List<ObjectId>): FindIterable<Exercise>? {
            return collection.find(`in`("_id", ids))
        }
    }
}