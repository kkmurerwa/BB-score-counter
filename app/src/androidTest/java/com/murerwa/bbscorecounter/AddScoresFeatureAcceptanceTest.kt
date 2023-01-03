package com.murerwa.bbscorecounter

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddScoresFeatureAcceptanceTest: BaseUITest() {
    @Test
    fun displayScreenTitle() {
        // Test whether the app title is accurate
        assertDisplayed(R.string.app_name)
    }

}