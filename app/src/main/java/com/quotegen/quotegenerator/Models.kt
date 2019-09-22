package com.quotegen.quotegenerator

data class Quote(val text: String, val author: String)
typealias QuoteSet = Pair<Quote,Quote>