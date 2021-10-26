package com.example.mvpexample

interface GetQuote {

    interface OnFinishedListener{
        fun onFinished(quote: String)
    }

    suspend fun getNextQuote(listener: OnFinishedListener)
}