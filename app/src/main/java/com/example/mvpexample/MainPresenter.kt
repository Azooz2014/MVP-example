package com.example.mvpexample

import kotlinx.coroutines.CoroutineScope

interface MainPresenter {

    fun onButtonClick()
    fun onDestroy()
}