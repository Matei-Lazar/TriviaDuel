package m.matthew.triviaduel.data.model

import com.squareup.moshi.Json

data class Question(
    val category: String,
    @Json(name = "correct_answer") val correctAnswer: String,
    val difficulty: String,
    @Json(name = "incorrect_answers") val incorrectAnswers: List<String>,
    val question: String,
    val type: String
)