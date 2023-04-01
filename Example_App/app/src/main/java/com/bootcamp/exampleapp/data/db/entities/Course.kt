package com.bootcamp.exampleapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course (
    @ColumnInfo(name = "course_name")
    var name: String,
    @ColumnInfo(name = "course_unit")
    var units: Int
    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}