package com.ardnn.academy.ui.academy

import com.ardnn.academy.data.AcademyRepository
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }

    @Test
    fun getCourse() {
        `when`(academyRepository.getAllCourses())
            .thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>)

        val courseEntities = viewModel.getCourses()
        verify(academyRepository).getAllCourses()

        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}