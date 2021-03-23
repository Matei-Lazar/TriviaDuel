package m.matthew.triviaduel.ui.home

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

    companion object {
        const val TAG = "HomeViewModel"
    }
}