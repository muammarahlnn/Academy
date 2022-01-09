package com.ardnn.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getCourse(): List<CourseEntity> = academyRepository.getAllCourses()
}