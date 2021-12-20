package com.ardnn.academy.ui.bookmark

import com.ardnn.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
