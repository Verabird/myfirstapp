package com.quotegen.quotegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

const val AUTHOR = "com.quotegen.quotegeenerator.AUTHOR"
const val QUOTE = "com.quotegen.quotegeenerator.QUOTE"

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val author0 = findViewById<TextView>(R.id.displayAuthor0)
        val quote0 = findViewById<TextView>(R.id.displayQuote0)
        val author1 = findViewById<TextView>(R.id.displayAuthor1)
        val quote1 = findViewById<TextView>(R.id.displayQuote1)
        val quoteObserver = Observer<QuoteSet> { quoteSet ->
            quote0.text = quoteSet.first.text
            quote1.text = quoteSet.second.text
            author0.text = quoteSet.first.author
            author1.text = quoteSet.second.author
        }
        viewModel.displayQuotes.observe(this, quoteObserver )
    }

    /** Called when the user taps the Send button */
    fun saveQuote(view: View) {
        val author = findViewById<EditText>(R.id.authorText)
        val text = findViewById<EditText>(R.id.quoteText)

        val newQuote = Quote(text.cleanText(),author.cleanText())
        viewModel.setQuote(newQuote)
        author.text.clear()
        text.text.clear()
    }
}

fun EditText.cleanText(): String {
    return this.text.toString().replace(regex = "\\s+".toRegex(), replacement = " ")
}