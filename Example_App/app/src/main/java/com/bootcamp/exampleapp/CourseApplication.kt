package com.bootcamp.exampleapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.exampleapp.data.db.entities.Course
import com.bootcamp.exampleapp.databinding.ActivityCourseBinding
import com.bootcamp.exampleapp.ui.course.AddCourseDialog
import com.bootcamp.exampleapp.ui.course.AddDialogListener
import com.bootcamp.exampleapp.adapter.CourseAdapter
import com.bootcamp.exampleapp.data.db.CourseDatabase
import com.bootcamp.exampleapp.data.db.respositories.CourseRepository
import com.bootcamp.exampleapp.ui.course.CourseViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CourseApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy { //lazy means that inside this block we can use the application context during binding time
        import(androidXModule(this@CourseApplication))
        bind() from singleton { CourseDatabase(instance()) } //When passing the instance parameter Kodein will automatically check for any object that fits for that parameter
        bind() from singleton { CourseRepository(instance()) } //Kodein will look at CourseDatabase and recognize that it fits as a parameter for CourseRepository
        bind() from provider {
            CourseViewModelFactory(instance()) //CourseRepository has already been instantiated
        }
    }
}