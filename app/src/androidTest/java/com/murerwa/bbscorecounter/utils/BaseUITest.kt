package com.murerwa.bbscorecounter.utils

import android.view.View
import android.view.ViewGroup
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.murerwa.bbscorecounter.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class BaseUITest {
    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

//    @Before
//    fun setup() {
//        IdlingRegistry.getInstance().register(idlingResource)
//    }
//
//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(idlingResource)
//    }

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("position $childPosition of parent ")
                parentMatcher.describeTo(description)
            }

            override fun matchesSafely(view: View): Boolean {
                if (view.parent !is ViewGroup) return false
                val parent = view.parent as ViewGroup

                return (parentMatcher.matches(parent)
                        && parent.childCount > childPosition
                        && parent.getChildAt(childPosition) == view)
            }
        }
    }

}