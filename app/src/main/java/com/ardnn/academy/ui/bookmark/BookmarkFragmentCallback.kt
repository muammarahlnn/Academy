package com.ardnn.academy.ui.bookmark

import com.ardnn.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
