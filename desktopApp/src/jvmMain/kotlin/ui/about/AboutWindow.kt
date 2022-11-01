package ui.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import com.poddlybonk.organize.presentation.AboutViewModel

@Composable
fun AboutWindow(viewModel: AboutViewModel = AboutViewModel(), onCloseRequest: () -> Unit) {
    Window(
        title = viewModel.title,
        state = WindowState(width = 300.dp, height = 450.dp),
        resizable = true,
        onCloseRequest = onCloseRequest
    ) {
        AboutView(viewModel = viewModel)
    }
}
