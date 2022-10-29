package edu.itvo.ejercicioquots.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.ejercicioquots.domain.model.QuoteModel
import edu.itvo.ejercicioquots.domain.usercase.AddQuoteUseCase
import edu.itvo.ejercicioquots.domain.usercase.GetQuoteRandomUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel
@Inject constructor(
    private val getQuoteRandomUseCase: GetQuoteRandomUseCase,
    private val addQuoteUseCase: AddQuoteUseCase
): ViewModel() {

    private val quoteModelRandomMutableStateFlow = MutableStateFlow(QuoteModel(0,"",""))
    private val quoteModelAddMutableStateFlow = MutableStateFlow(0L)
    val quoteModel: StateFlow<QuoteModel> = quoteModelRandomMutableStateFlow
    val addQuoteModel: StateFlow<Long> = quoteModelAddMutableStateFlow


    fun randomQuote() {
        viewModelScope.launch {
            quoteModelRandomMutableStateFlow.value = getQuoteRandomUseCase.getQuoteRandom().first()
            //_quoteModel.value = GetQuoteUseCase(quoteDAO).getQuote(1).first()
        }
    }

    fun addQuote(quote: QuoteModel){
        viewModelScope.launch {
            quoteModelAddMutableStateFlow.value = addQuoteUseCase.addQuote(quote)
        }
    }
}
