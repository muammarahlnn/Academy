package com.ardnn.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.CourseEntity
import com.ardnn.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {
    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses()
}