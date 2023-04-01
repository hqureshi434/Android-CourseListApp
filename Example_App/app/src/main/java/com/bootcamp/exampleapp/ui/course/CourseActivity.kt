package com.bootcamp.exampleapp.ui.course

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.exampleapp.adapter.CourseAdapter
import com.bootcamp.exampleapp.data.db.entities.Course
import com.bootcamp.exampleapp.databinding.ActivityCourseBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class CourseActivity: AppCompatActivity(), KodeinAware {
    private lateinit var binding: ActivityCourseBinding
    override val kodein by kodein()
    private val factory: CourseViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, factory)[CourseViewModel::class.java]
        val adapter = CourseAdapter(listOf(), viewModel)
        binding.rvCourses.layoutManager = LinearLayoutManager(this)
        binding.rvCourses.adapter = adapter

        viewModel.getAllCourses().observe(this) {
            adapter.courses = it
            adapter.notifyDataSetChanged()
        }

        binding.btnAdd.setOnClickListener{
            AddCourseDialog(this,
                object : AddDialogListener {
                override fun onAddButtonClicked(course: Course) {
                    viewModel.insert(course)
                }
            }).show()
        }
    }
}