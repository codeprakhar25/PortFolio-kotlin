package com.example.portfolio.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.portfolio.data.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM TODO")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun createTodo(todo: Todo)

//    @Delete
//    fun DeleteTodo(id : Int)
}