package m.matthew.triviaduel.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.util.ListConverter

@Database(entities = [QuestionEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class TriviaDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        val DATABASE_NAME: String = "trivia_db"
    }
}