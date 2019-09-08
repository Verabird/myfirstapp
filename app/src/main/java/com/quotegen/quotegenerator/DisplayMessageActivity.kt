package com.quotegen.quotegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val quote = intent.getStringExtra(QUOTE)
        val author = intent.getStringExtra(AUTHOR)
        // Capture the layout's TextView and set the string as its text
        findViewById<TextView>(R.id.textView).apply {
            text = quote
        }
        findViewById<TextView>(R.id.displayAuthor).apply {
            text = author
        }
    }
}
