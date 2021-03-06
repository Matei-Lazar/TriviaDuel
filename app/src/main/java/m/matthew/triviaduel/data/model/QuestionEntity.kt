package m.matthew.triviaduel.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "questions")
data class QuestionEntity constructor(
        val category: String,
        val type: String,
        val difficulty: String,
        val question: String,

        @ColumnInfo(name = "correct_answer")
        val correctAnswer: String,

        @ColumnInfo(name = "incorrect_answers")
        val incorrectAnswers: List<String>,
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long = 0
}