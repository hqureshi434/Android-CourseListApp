package com.bootcamp.exampleapp.data.db.respositories

import com.bootcamp.exampleapp.data.db.CourseDatabase
import com.bootcamp.exampleapp.data.db.entities.Course

class CourseRepository(
    private val db: CourseDatabase
) {
    suspend fun insert(course: Course) = db.getCourseDao().insertCourse(course)

    suspend fun delete(course: Course) = db.getCourseDao().deleteCourse(course)

    fun getAllCourses() = db.getCourseDao().getAllCourses()
}