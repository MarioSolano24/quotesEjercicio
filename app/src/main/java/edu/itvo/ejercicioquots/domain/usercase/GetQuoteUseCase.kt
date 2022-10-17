package edu.itvo.ejercicioquots.domain.usercase

import edu.itvo.ejercicioquots.domain.QuoteRepository
import edu.itvo.ejercicioquots.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuote(quoteId:Int):Flow<QuoteModel> = quoteRepository.getQuote(quoteId)

}