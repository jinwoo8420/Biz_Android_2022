package com.callor.word.persistance

import androidx.annotation.WorkerThread
import com.callor.word.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords : Flow<List<Word>> = wordDao.selectAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word:Word) {
        wordDao.insert(word)
    }
}