package com.poddlybonk.organize.android

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.poddlybonk.organize.android.ui.root.MainActivity
import org.junit.Rule
import org.junit.Test

class AppUITest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testAboutButtonExistence() {
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .assertIsDisplayed()
    }
}