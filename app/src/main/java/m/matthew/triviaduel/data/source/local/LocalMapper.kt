package m.matthew.triviaduel.data.source.local

import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.data.model.TriviaResponse
import m.matthew.triviaduel.util.QuestionEntityMapper
import javax.inject.Inject

class LocalMapper
@Inject
constructor() : QuestionEntityMapper<TriviaResponse> {
    override fun mapToEntity(response: TriviaResponse): List<QuestionEntity> {
        val list: MutableList<QuestionEntity> = mutableListOf()

        for (result in response.results) {
            list.add(
                QuestionEntity
                    (
                    category = result.category,
                    type = result.type,
                    difficulty = result.difficulty,
                    question = result.question,
                    correctAnswer = result.correctAnswer,
                    incorrectAnswers = result.incorrectAnswers
            ))
        }

        return list.toList()
    }
}