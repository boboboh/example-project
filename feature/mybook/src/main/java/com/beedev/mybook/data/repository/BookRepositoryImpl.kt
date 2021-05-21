package com.beedev.mybook.data.repository

import com.beedev.core.common.Either
import com.beedev.core.common.Failure
import com.beedev.mybook.data.api.BookApi
import com.beedev.mybook.domain.model.BookModel
import com.beedev.mybook.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookApi: BookApi
) : BookRepository {
    override fun getBook(): Either<Failure, List<BookModel>> {
        bookApi.getMyBook().execute().run {
            return when {
                body() == null || code() != 200 -> Either.Left(Failure.ServerError)
                else -> Either.Right(body() ?: listOf())
            }
        }
    }

    override fun setBook(title: String): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }
}