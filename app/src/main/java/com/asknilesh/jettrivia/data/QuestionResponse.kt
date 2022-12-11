package com.asknilesh.jettrivia.data

data class QuestionResponse(
    val response_code: Int,
    val results: List<Question>
)