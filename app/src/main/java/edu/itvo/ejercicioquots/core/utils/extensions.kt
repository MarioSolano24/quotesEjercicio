package edu.itvo.ejercicioquots.core.utils

import edu.itvo.ejercicioquots.data.local.entities.QuoteEntity
import edu.itvo.ejercicioquots.domain.model.QuoteModel

fun QuoteEntity.toQuoteModel() = QuoteModel(
    id=id,
    quote = quote,
    author = author,
)
fun QuoteModel.toEntity() = QuoteEntity(
    id= id,
    quote = quote,
    author = author,
)

fun List<QuoteModel>.toListQuoteEntity () =
    map {it.toEntity() }

fun List<QuoteEntity>.toListQuoteModel () =
    map {it.toQuoteModel() }