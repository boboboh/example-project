package com.beedev.core.common

sealed class ViewState

object ShowLoading : ViewState()
object HideLoading : ViewState()

class Error(val error: Throwable = Throwable()) : ViewState()