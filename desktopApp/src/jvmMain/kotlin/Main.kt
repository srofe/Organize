import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.poddlybonk.organize.presentation.Screen
import ui.about.AboutView
import ui.about.AboutWindow
import ui.reminders.RemindersView
import ui.theme.AppTheme

fun main() {
    return application {
        var screenState by remember { mutableStateOf(Screen.Reminders) }

        AppTheme {
            Window(
                title = "Organize",
                state = rememberWindowState(width = 400.dp, height = 550.dp),
                resizable = true,
                onCloseRequest = ::exitApplication
            ) {
                RemindersView(
                    onAboutButtonClick = { screenState = Screen.AboutDevice }
                )
            }

            if (screenState == Screen.AboutDevice) {
                AboutWindow {
                    screenState = Screen.Reminders
                }
            }
        }
    }
}
