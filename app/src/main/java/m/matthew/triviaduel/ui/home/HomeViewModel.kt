package m.matthew.triviaduel.ui.home

import android.os.Build
import android.text.Html
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import m.matthew.triviaduel.data.model.TriviaResponse
import m.matthew.triviaduel.data.source.remote.TriviaApi


class HomeViewModel : ViewModel() {

    private val _triviaResponse = MutableLiveData<TriviaResponse>()

    val triviaResponse: LiveData<TriviaResponse>
        get() = _triviaResponse

    init {
        getAQuestion()
    }

    private fun getAQuestion() {
        viewModelScope.launch {
            try {
                _triviaResponse.value = TriviaApi.retrofitService.getQuestion()
                Log.i(TAG, "Success")
            } catch (e: Exception) {
                Log.e(TAG, "Exception: ${e.message}")
            }
        }
    }

    fun decodeHtml(string: String?): String {
        return if (string != null) {
            Html.fromHtml(string, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            "Error"
        }
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}