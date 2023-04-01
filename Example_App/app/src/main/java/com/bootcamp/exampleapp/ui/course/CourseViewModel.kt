package com.bootcamp.exampleapp.ui.course

import androidx.lifecycle.ViewModel
import com.bootcamp.exampleapp.data.db.entities.Course
import com.bootcamp.exampleapp.data.db.respositories.CourseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(
    private val respository: CourseRepository
): ViewModel() {
    fun insert(course: Course) = CoroutineScope(Dispatchers.Main).launch {//Dispatchers.Main means that we want to start the Coroutine in the main thread
        respository.insert(course)
    }

    fun delete(course: Course) = CoroutineScope(Dispatchers.Main).launch {
        respository.delete(course)
    }

    fun getAllCourses() = respository.getAllCourses()
}