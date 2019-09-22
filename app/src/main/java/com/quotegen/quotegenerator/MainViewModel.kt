package com.quotegen.quotegenerator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val defaultQuote0 = Quote("Do or do not, there is no try.", "Yoda")
    private val defaultQuote1 = Quote("I pity the fool!", "Mr. T")

    val displayQuotes: MutableLiveData<QuoteSet> = MutableLiveData<QuoteSet>()
        .apply{ postValue(Pair(defaultQuote0,defaultQuote1)) }

    fun setQuote(quote: Quote) {
        val oldQuote = displayQuotes.value?.first ?: defaultQuote0
        displayQuotes.value = Pair(quote, oldQuote)
    }
}