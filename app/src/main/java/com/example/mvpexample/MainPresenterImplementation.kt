package com.example.mvpexample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainPresenterImplementation(private var view: MainView, private var getQuote: GetQuote): MainPresenter,
    GetQuote.OnFinishedListener{

    private var job = Job()
    private val instance: MainPresenterImplementation = this
    private val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val scope: CoroutineScope = CoroutineScope(coroutineContext)

    override fun onButtonClick() {

        view.showProgressBar()

        scope.launch(Dispatchers.IO) { //running on background thread

            getQuote.getNextQuote(instance)
        }
    }

    override fun onDestroy() {
        return
    }

    override fun onFinished(quote: String) {

        scope.launch(Dispatchers.Main) { //switching back to Main(UI) thread
            view.setQuote(quote)
            view.hideProgressBar()
        }
    }
}