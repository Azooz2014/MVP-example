package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var button: Button
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        presenter = MainPresenterImplementation(this,GetQuoteImplementation())

        button.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE

        //Toast.makeText(this,"showing progress bar", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
        textView.visibility = View.VISIBLE

        //Toast.makeText(this,"hiding progress bar", Toast.LENGTH_SHORT).show()
    }

    override fun setQuote(quote: String) {
        textView.text = quote
    }
}