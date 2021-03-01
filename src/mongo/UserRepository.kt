package com.github.mongo

import com.github.models.User
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById

class UserRepository {
    companion object {
        private const val collectionName = "users"
        private val collection = MongoInterface.database.getCollection(collectionName, User::class.java)

        fun getById(id: String): User? {
            return collection.findOneById(ObjectId(id))
        }
    }
}