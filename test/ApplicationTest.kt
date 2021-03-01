package com.github

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
//            val userId = "603919060e85ae02ac9d438a"
//            val date = "2021/02/27"
//            handleRequest(HttpMethod.Get, "/day?userId=$userId&date=$date").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
        }
    }
}
