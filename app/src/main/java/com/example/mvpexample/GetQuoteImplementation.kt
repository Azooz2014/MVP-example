package com.example.mvpexample

import kotlinx.coroutines.*
import kotlin.random.Random

class GetQuoteImplementation: GetQuote {

    private val quotes: List<String> = listOf("Be yourself. everyone else is already taken.",
        "A room without books is like a body without a soul.",
        "You only live once, but if you do it right, once is enough.",
        "Be the change that you wish to see in the world.",
        "If you tell the truth, you don't have to remember anything.")

    override suspend fun getNextQuote(listener: GetQuote.OnFinishedListener) {

        withContext(Dispatchers.IO) {
            launch {
                delay(1200)
                listener.onFinished(getRandomQuote())
            }
        }
    }

    private fun getRandomQuote(): String {

        val index = Random.nextInt(until = quotes.size)

        return quotes[index]
    }
}