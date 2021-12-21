package com.ardnn.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.CourseEntity
import com.ardnn.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyBookmarks()
}