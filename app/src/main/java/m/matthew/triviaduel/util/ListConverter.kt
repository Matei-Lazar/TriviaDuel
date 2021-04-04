package m.matthew.triviaduel.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import m.matthew.triviaduel.data.model.QuestionEntity

class ListConverter {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}