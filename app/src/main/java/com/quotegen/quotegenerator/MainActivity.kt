package com.quotegen.quotegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val AUTHOR = "com.quotegen.quotegeenerator.AUTHOR"
const val QUOTE = "com.quotegen.quotegeenerator.QUOTE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val authorText = findViewById<EditText>(R.id.authorText)
        val author = authorText.text.toString()

        val quoteText = findViewById<EditText>(R.id.quoteText)
        val quote = quoteText.text.toString().replace(regex = "\\s+".toRegex(), replacement = " ")

        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(AUTHOR, author)
            putExtra(QUOTE, quote)
        }
        startActivity(intent)
    }
}
