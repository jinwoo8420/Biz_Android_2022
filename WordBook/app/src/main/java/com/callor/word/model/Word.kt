package com.callor.word.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "seq")
    val seq : Long,

    @ColumnInfo(name = "word")
    val word : String
)