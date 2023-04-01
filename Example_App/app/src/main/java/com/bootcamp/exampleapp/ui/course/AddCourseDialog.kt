package com.bootcamp.exampleapp.ui.course

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.bootcamp.exampleapp.data.db.entities.Course
import com.bootcamp.exampleapp.databinding.DialogAddCourseBinding

class AddCourseDialog (context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context){
    private lateinit var binding: DialogAddCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddCourseBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val courseName = binding.etCourseName.text.toString()
            val courseUnit = binding.etUnit.text.toString().toInt()

            if(courseName.isNullOrEmpty()){
                Toast.makeText(context, "Please enter a course name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val course = Course(courseName, courseUnit)
            addDialogListener.onAddButtonClicked(course)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}