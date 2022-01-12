package com.ardnn.academy.data

import androidx.lifecycle.LiveData
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.source.local.entity.ModuleEntity

interface AcademyDataSource {
    fun getAllCourses(): LiveData<List<CourseEntity>>
    fun getBookmarkCourses(): LiveData<List<CourseEntity>>
    fun getCourseWithModules(courseId: String): LiveData<CourseEntity>
    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>
    fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>
}