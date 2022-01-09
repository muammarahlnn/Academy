package com.ardnn.academy.data

import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.source.local.entity.ModuleEntity

interface AcademyDataSource {
    fun getAllCourses(): List<CourseEntity>
    fun getBookmarkCourses(): List<CourseEntity>
    fun getCourseWithModules(courseId: String): CourseEntity
    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>
    fun getContent(courseId: String, moduleId: String): ModuleEntity
}