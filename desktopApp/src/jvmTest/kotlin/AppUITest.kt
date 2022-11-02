import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.poddlybonk.organize.presentation.Screen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ui.about.AboutView
import ui.reminders.RemindersView

class AppUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            var screenState by remember { mutableStateOf(Screen.Reminders) }

            when (screenState) {
                Screen.Reminders ->
                    RemindersView(
                        onAboutButtonClick = { screenState = Screen.AboutDevice }
                    )
                Screen.AboutDevice -> AboutView()
            }
        }
    }

    @Test
    fun testAboutButtonExistence() {
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .assertExists()
    }

    @Test
    fun testOpeningAboutPage() {
        composeTestRule
            .onNodeWithContentDescription("Reminders")
            .assertExists()
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .assertExists()
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithContentDescription("aboutView")
            .assertExists()
    }
}
