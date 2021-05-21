package com.beedev.mybook.domain.repository

import com.beedev.core.common.Either
import com.beedev.core.common.Failure
import com.beedev.mybook.domain.model.BookModel

interface BookRepository {
    fun getBook(): Either<Failure, List<BookModel>>
    fun setBook(title: String): Either<Failure, Unit>
}