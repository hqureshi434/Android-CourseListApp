package com.bootcamp.exampleapp.ui.course

import com.bootcamp.exampleapp.data.Course

interface AddDialogListener {
    fun onAddButtonClicked(course: Course)
}