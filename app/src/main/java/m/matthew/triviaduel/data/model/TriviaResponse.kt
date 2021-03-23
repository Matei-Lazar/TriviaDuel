package m.matthew.triviaduel.data.model

import com.squareup.moshi.Json
import m.matthew.triviaduel.data.model.Question

data class TriviaResponse
    (
    @Json(name = "response_code") val responseCode: Int,
    val results: List<Question>
    )