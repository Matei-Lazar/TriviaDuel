package m.matthew.triviaduel.util

import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.data.model.TriviaResponse

interface QuestionEntityMapper<TriviaResponse> {
    fun mapToEntity(response: TriviaResponse): List<QuestionEntity>
}