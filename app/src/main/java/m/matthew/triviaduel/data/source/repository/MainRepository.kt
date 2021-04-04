package m.matthew.triviaduel.data.source.repository

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.data.source.local.LocalMapper
import m.matthew.triviaduel.data.source.local.QuestionDao
import m.matthew.triviaduel.data.source.remote.TriviaApiService
import m.matthew.triviaduel.util.DataState

import m.matthew.triviaduel.util.QuestionEntityMapper

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
            Log.i(TAG, "1 Got a question")
            val questions = localMapper.mapToEntity(response)
            Log.i(TAG, "2 Mapped question to entity")
            for (question in questions) {
                questionDao.insertQuestion(question)
                Log.i(TAG, "3 Insert question in the database")
            }
            val cachedQuestions = questionDao.getQuestions()
            Log.i(TAG, "4 Got questions from the database")
            emit(DataState.Success(cachedQuestions))
            Log.i(TAG, "5 Emited DataState.Success")
        } catch (e: Exception) {
            emit(DataState.Error(e))
            Log.i(TAG, "6 Emitted DataState.Error")
        }
    }

    companion object {
        const val TAG = "MainRepository"
    }
}