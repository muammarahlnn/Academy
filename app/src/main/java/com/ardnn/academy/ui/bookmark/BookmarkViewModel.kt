package com.ardnn.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getBookmarks(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkCourses()
}