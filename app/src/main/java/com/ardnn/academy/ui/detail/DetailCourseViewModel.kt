package com.ardnn.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.data.source.local.entity.ModuleEntity
import com.ardnn.academy.data.AcademyRepository
import com.ardnn.academy.data.source.local.entity.CourseWithModule
import com.ardnn.academy.vo.Resource

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    val courseId = MutableLiveData<String>()
    var courseModule: LiveData<Resource<CourseWithModule>> =
        Transformations.switchMap(courseId) { courseId ->
            academyRepository.getCourseWithModules(courseId)
        }

    fun setSelectedCourse(courseId: String) {
        this.courseId.value = courseId
    }

    fun setBookmark() {
        val moduleResource = courseModule.value
        if (moduleResource != null) {
            val courseWithModule = moduleResource.data

            if (courseWithModule != null) {
                val courseEntity = courseWithModule.mCourse
                val newState = !courseEntity.bookmarked
                academyRepository.setCourseBookmark(courseEntity, newState)
            }
        }
    }
}