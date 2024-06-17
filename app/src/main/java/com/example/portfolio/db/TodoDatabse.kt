package com.example.portfolio.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.portfolio.data.Todo


@Database(entities = [Todo::class],version=1)
abstract class TodoDatabse  : RoomDatabase() {

    companion object {
        const val NAME = "TODO_DB"
    }

    abstract fun getTOdo(): TodoDao
}