package ui.reminders

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import com.poddlybonk.organize.presentation.RemindersViewModel

@Composable
fun RemindersWindow(
    viewModel: RemindersViewModel = RemindersViewModel(),
    onCloseRequest: () -> Unit,
    onAboutButtonClick: () -> Unit
) {
    Window(
        title = "Organise",
        state = rememberWindowState(width = 400.dp, height = 550.dp),
        resizable = true,
        onCloseRequest = onCloseRequest
    ) {
        RemindersView(viewModel = viewModel, onAboutButtonClick = onAboutButtonClick)
    }
}
