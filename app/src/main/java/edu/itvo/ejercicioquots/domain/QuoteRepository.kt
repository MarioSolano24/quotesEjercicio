package edu.itvo.ejercicioquots.domain

import edu.itvo.ejercicioquots.domain.model.QuoteModel
import edu.itvo.ejercicioquots.domain.usercase.GetQuoteUseCase
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuoteRandom():Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
}