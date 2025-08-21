package com.toolrental.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ToolViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ToolViewModel

    @Before
    fun setup() {
        viewModel = ToolViewModel()
    }

    @Test
    fun searchTools_returnsNoTools_ifNoToolsMatchQuery() {
        viewModel.searchTools("non-existent tool")
        val tools = viewModel.tools.value
        assertEquals(0, tools?.size)
    }
}
