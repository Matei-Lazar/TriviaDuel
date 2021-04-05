package m.matthew.triviaduel.data.source.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.data.source.local.LocalMapper
import m.matthew.triviaduel.data.source.local.QuestionDao
import m.matthew.triviaduel.data.source.remote.TriviaApiService
import m.matthew.triviaduel.util.DataState


class MainRepository
constructor(
        private val questionDao: QuestionDao,
        private val triviaApiService: TriviaApiService,
        private val localMapper: LocalMapper
) {
    suspend fun getQuestion(): Flow<DataState<List<QuestionEntity>>> = flow {
        emit(DataState.Loading)
        try {
            val response = triviaApiService.getQuestion()
            val questions = localMapper.mapToEntity(response)
            for (question in questions) {
                questionDao.insertQuestion(question)
            }
            val cachedQuestions = questionDao.getQuestions()
            emit(DataState.Success(cachedQuestions))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    companion object {
        const val TAG = "MainRepository"
    }
}