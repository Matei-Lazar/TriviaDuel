package m.matthew.triviaduel.data.source.local

import androidx.room.*
import m.matthew.triviaduel.data.model.QuestionEntity

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(questionEntity: QuestionEntity)

    @Query("DELETE FROM questions")
    suspend fun nukeQuestions()

    @Query("SELECT * FROM questions")
    suspend fun getQuestions(): List<QuestionEntity>

    @Query("SELECT * FROM questions WHERE category == :category")
    suspend fun get10QuestionsFromCategory(category: String): List<QuestionEntity>
}