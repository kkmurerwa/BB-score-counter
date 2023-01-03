package com.murerwa.bbscorecounter.utils

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

open class BaseUnitTest {

    @get:Rule
    val coroutinesTestRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

}