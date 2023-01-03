package com.murerwa.bbscorecounter

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.internal.matcher.withCompatText
import com.murerwa.bbscorecounter.utils.BaseUITest
import org.hamcrest.core.AllOf.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddScoresFeatureAcceptanceTest: BaseUITest() {
    @Test
    fun displayScreenTitle() {
        // Test whether the app name is displayed on title
        assertDisplayed(R.string.app_name)
    }

    @Test
    fun displayScoreTextViewsAndCorrectBeginningScore() {
        assertDisplayed(R.id.text_score_team_a)
        assertDisplayed(R.id.text_score_team_b)

        onView(allOf(withId(R.id.text_score_team_a)))
            .check(matches(withCompatText("0")))
        onView(allOf(withId(R.id.text_score_team_b)))
            .check(matches(withCompatText("0")))
    }

    @Test
    fun displayButtonScoreIncrementerButtons() {
        assertDisplayed(R.id.button_add_1pt_to_team_a)
        assertDisplayed(R.id.button_add_2pts_to_team_a)
        assertDisplayed(R.id.button_add_3pts_to_team_a)

        assertDisplayed(R.id.button_add_1pt_to_team_b)
        assertDisplayed(R.id.button_add_2pts_to_team_b)
        assertDisplayed(R.id.button_add_3pts_to_team_b)
    }

    @Test
    fun teamAButtonsIncrementScoreAsExpected() {
        onView(withId(R.id.button_add_1pt_to_team_a)).perform(click())
        onView(allOf(withId(R.id.text_score_team_a)))
            .check(matches(withCompatText("1")))

        onView(withId(R.id.button_add_2pts_to_team_a)).perform(click())
        onView(allOf(withId(R.id.text_score_team_a)))
            .check(matches(withCompatText("3")))

        onView(withId(R.id.button_add_3pts_to_team_a)).perform(click())
        onView(allOf(withId(R.id.text_score_team_a)))
            .check(matches(withCompatText("6")))

    }

    @Test
    fun teamBButtonsIncrementScoreAsExpected() {
        onView(withId(R.id.button_add_1pt_to_team_b)).perform(click())
        onView(allOf(withId(R.id.text_score_team_b)))
            .check(matches(withCompatText("1")))

        onView(withId(R.id.button_add_2pts_to_team_b)).perform(click())
        onView(allOf(withId(R.id.text_score_team_b)))
            .check(matches(withCompatText("3")))

        onView(withId(R.id.button_add_3pts_to_team_b)).perform(click())
        onView(allOf(withId(R.id.text_score_team_b)))
            .check(matches(withCompatText("6")))
    }
}