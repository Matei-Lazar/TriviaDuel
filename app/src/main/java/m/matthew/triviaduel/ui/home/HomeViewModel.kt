package m.matthew.triviaduel.ui.home

import android.text.Html
import androidx.lifecycle.*
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import m.matthew.triviaduel.data.model.QuestionEntity
import m.matthew.triviaduel.data.source.repository.MainRepository
import m.matthew.triviaduel.util.DataState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
            private val mainRepository: MainRepository
    ) : ViewModel() {
// vezi si chestia aia cu viewmodel si navigation graph

    private val _dataState: MutableLiveData<DataState<List<QuestionEntity>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<QuestionEntity>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetQuestionsEvent -> {
                    mainRepository.getQuestion()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

    sealed class MainStateEvent {
        object GetQuestionsEvent: MainStateEvent()
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