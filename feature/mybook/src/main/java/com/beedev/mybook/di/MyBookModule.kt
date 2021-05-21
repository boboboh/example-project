package com.beedev.mybook.di

import com.beedev.mybook.data.api.BookApi
import com.beedev.mybook.data.repository.BookRepositoryImpl
import com.beedev.mybook.domain.repository.BookRepository
import com.beedev.mybook.domain.usecase.GetMyBookUseCase
import com.beedev.mybook.presentation.MyBookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val myBookModule = module {

    single { (get(named("Retrofit")) as Retrofit).create(BookApi::class.java) }

    single<BookRepository> {
        BookRepositoryImpl(bookApi = get())
    }

    factory {
        GetMyBookUseCase(bookRepository = get())
    }

    viewModel {
        MyBookViewModel(getMyBookUseCase = get())
    }
}