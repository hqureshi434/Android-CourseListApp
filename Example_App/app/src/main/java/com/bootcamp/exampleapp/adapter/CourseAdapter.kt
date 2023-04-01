package com.bootcamp.exampleapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.exampleapp.R
import com.bootcamp.exampleapp.data.db.entities.Course
import com.bootcamp.exampleapp.ui.course.CourseViewModel

class CourseAdapter(
    var courses: List<Course>,
    private val viewModel: CourseViewModel
    ): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_unit, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
       val curCourse = courses[position]

       holder.itemView.findViewById<TextView>(R.id.tvCourseName).text = curCourse.name
       holder.itemView.findViewById<TextView>(R.id.tvCourseUnit).text = "${curCourse.units}"

        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewModel.delete(curCourse)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivAdd).setOnClickListener{
            curCourse.units++
            viewModel.insert(curCourse)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener{
            if(curCourse.units > 0) {
                curCourse.units--
                viewModel.insert(curCourse)
            }
        }
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    inner class CourseViewHolder(courseView: View): RecyclerView.ViewHolder(courseView)
}