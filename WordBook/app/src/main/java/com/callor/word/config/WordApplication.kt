package com.callor.word.config

import android.app.Application
import com.callor.word.persistance.WordDatabase
import com.callor.word.persistance.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordApplication : Application() {
    private val appScope = CoroutineScope(SupervisorJob())
    private val database by lazy { WordDatabase.getDataBase(this, appScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}