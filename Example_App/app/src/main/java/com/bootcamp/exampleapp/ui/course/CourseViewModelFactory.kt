package com.bootcamp.exampleapp.ui.course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bootcamp.exampleapp.data.db.respositories.CourseRepository

class CourseViewModelFactory(
    private val respository: CourseRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return CourseViewModel(respository) as T
    }
}