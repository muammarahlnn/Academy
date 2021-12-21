package com.ardnn.academy.ui.bookmark

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmarks() {
        val courseEntities = viewModel.getBookmarks()
        assertNotNull(courseEntities)
        assertEquals(15, courseEntities.size)
    }
}