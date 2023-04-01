package com.bootcamp.exampleapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.exampleapp.data.db.entities.Course

@Database(
    entities = [Course::class],
    version = 1
)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun getCourseDao(): CourseDAO

    companion object {
        @Volatile //Want to ensure that one thread is being written to instance
        private var instance: CourseDatabase? = null
        private val LOCK = Any()

        //Instance is a nullable private variable. In the function below it will create an instance of a database if instance is null
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CourseDatabase::class.java,
                "course_database.db").build()
    }
}
