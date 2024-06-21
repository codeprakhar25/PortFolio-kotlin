package com.example.portfolio.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(

    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var created_at: String,
    var title:String
)
