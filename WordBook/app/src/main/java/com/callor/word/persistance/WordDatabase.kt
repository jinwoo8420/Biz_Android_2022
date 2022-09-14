package com.callor.word.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.callor.word.model.Word
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao() : WordDao

    companion object {
        private var DB_CONN : WordDatabase? = null
        fun getDataBase (
            context : Context,
            scope : CoroutineScope
        ) : WordDatabase {
            return DB_CONN ?: synchronized(this) {
                val conn = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "WordDB"
                ).fallbackToDestructiveMigration().build()
                DB_CONN = conn
                conn
            }
        }
    }
}