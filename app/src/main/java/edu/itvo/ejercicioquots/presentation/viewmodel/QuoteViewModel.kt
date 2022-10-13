package edu.itvo.ejercicioquots.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.itvo.ejercicioquots.data.QuoteProvider
import edu.itvo.ejercicioquots.domain.model.QuoteModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    private val _quoteModel = MutableStateFlow(QuoteModel("",""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    //---  Load data from a suspend fun and mutate state
    fun randomQuote() {
        viewModelScope.launch {
            val quote= QuoteProvider.random()
            _quoteModel.value = quote
        }
    }
}