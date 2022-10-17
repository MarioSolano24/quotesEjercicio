package edu.itvo.ejercicioquots.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.ejercicioquots.data.QuoteRepositoryImpl
import edu.itvo.ejercicioquots.data.local.QuoteLocalDataSource
import edu.itvo.ejercicioquots.data.local.QuoteLocalDataSourceImpl
import edu.itvo.ejercicioquots.domain.QuoteRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

}
