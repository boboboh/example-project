package com.beedev.mybook.domain.usecase

import com.beedev.core.common.BaseUseCase
import com.beedev.core.common.Either
import com.beedev.core.common.Failure
import com.beedev.mybook.domain.model.BookModel
import com.beedev.mybook.domain.repository.BookRepository

class GetMyBookUseCase(
    private val bookRepository: BookRepository
) : BaseUseCase<List<BookModel>, BaseUseCase.None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> {
        return bookRepository.getBook()
    }
}