package com.bootcamp.exampleapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.exampleapp.data.Course
import com.bootcamp.exampleapp.databinding.ActivityCourseBinding
import com.bootcamp.exampleapp.ui.course.AddCourseDialog
import com.bootcamp.exampleapp.ui.course.AddDialogListener
import com.bootcamp.exampleapp.ui.course.CourseAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCourses.layoutManager = LinearLayoutManager(this)
        //val courseList = mutableListOf<Course>()

        binding.btnAdd.setOnClickListener{
            val addCourseDialog = AddCourseDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(course: Course) {
                    val courseList: MutableList<Course> = mutableListOf(course)
                    courseList.add(course)
                    val adapter = CourseAdapter(courseList)
                    binding.rvCourses.adapter = adapter
                }
            })
            addCourseDialog.show()
        }


    }
}