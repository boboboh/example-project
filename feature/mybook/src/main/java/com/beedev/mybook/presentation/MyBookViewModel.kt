package com.beedev.mybook.presentation

import androidx.lifecycle.MutableLiveData
import com.beedev.core.common.BaseUseCase
import com.beedev.core.common.BaseViewModel
import com.beedev.core.common.onSuccess
import com.beedev.mybook.domain.model.BookModel
import com.beedev.mybook.domain.usecase.GetMyBookUseCase

class MyBookViewModel(
    private val getMyBookUseCase: GetMyBookUseCase
) : BaseViewModel() {

    val bookList = MutableLiveData<List<BookModel>>()

    fun getMyBook() {
        getMyBookUseCase(BaseUseCase.None()) { either ->
            either.onSuccess {
                bookList.value = it
            }
        }
    }
}