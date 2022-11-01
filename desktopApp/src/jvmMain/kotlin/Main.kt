import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import com.poddlybonk.organize.presentation.Screen
import ui.about.AboutWindow
import ui.reminders.RemindersWindow
import ui.theme.AppTheme

fun main() {
    return application {
        var screenState by remember { mutableStateOf(Screen.Reminders) }

        AppTheme {
            RemindersWindow(
                onCloseRequest = ::exitApplication,
                onAboutButtonClick = { screenState = Screen.AboutDevice }
            )

            if (screenState == Screen.AboutDevice) {
                AboutWindow {
                    screenState = Screen.Reminders
                }
            }
        }
    }
}
