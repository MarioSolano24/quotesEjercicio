package edu.itvo.ejercicioquots.domain.usercase

import edu.itvo.ejercicioquots.domain.QuoteRepository
import edu.itvo.ejercicioquots.domain.model.QuoteModel
import javax.inject.Inject

class AddQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun addQuote(quote: QuoteModel): Long = quoteRepository.addQuote(quote)
}