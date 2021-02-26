package com.github.mongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import io.github.cdimascio.dotenv.dotenv
import org.litote.kmongo.KMongo

class MongoInterface {
    companion object {
        lateinit var client: MongoClient
        lateinit var database: MongoDatabase

        fun initialize() {
            if (this::client.isInitialized && this::database.isInitialized) return

            val username = dotenv()["DATABASE_USERNAME"]
            val password = dotenv()["DATABASE_PASSWORD"]
            client =
                KMongo.createClient(
                    "mongodb+srv://${username}:${password}@cluster0.ubt7i.mongodb.net/four-fit-life?retryWrites=true&w=majority"
                )
            database = client.getDatabase("four-fit-life")
        }
    }
}