package com.bootcamp.exampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bootcamp.exampleapp.data.db.entities.Course

@Dao
interface CourseDAO {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<Course>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course): Long

    @Delete
    suspend fun deleteCourse(course: Course)
}