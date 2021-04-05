package m.matthew.triviaduel.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "questions")
data class QuestionEntity constructor(
        @ColumnInfo(name = "category")
        val category: String,

        @ColumnInfo(name = "type")
        val type: String,

        @ColumnInfo(name = "difficulty")
        val difficulty: String,

        @ColumnInfo(name = "question")
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