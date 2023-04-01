package com.bootcamp.exampleapp.ui.course

import com.bootcamp.exampleapp.data.db.entities.Course

interface AddDialogListener {
    fun onAddButtonClicked(course: Course)
}