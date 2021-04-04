package m.matthew.triviaduel.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import m.matthew.triviaduel.data.model.QuestionEntity

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(questionEntity: QuestionEntity)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertQuestions(questions: List<QuestionEntity>)

    @Query("SELECT * FROM questions")
    suspend fun getQuestions(): List<QuestionEntity>
}