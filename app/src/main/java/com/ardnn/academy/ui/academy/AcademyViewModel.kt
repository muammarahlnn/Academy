package com.ardnn.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.AcademyRepository
import com.ardnn.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}