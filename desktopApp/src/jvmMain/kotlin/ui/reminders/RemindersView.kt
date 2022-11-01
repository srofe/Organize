package ui.reminders

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.poddlybonk.organize.domain.Reminder
import com.poddlybonk.organize.presentation.RemindersViewModel

@Composable
fun RemindersView(
    viewModel: RemindersViewModel = RemindersViewModel(),
    onAboutButtonClick: () -> Unit
) {
    Column {
        Toolbar(title = viewModel.title, onAboutButtonClick = onAboutButtonClick)
        ContentView(viewModel = viewModel)
    }
}

@Composable
private fun Toolbar(
    title: String,
    onAboutButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button"
                )
            }
        }
    )
}

@Composable
private fun ContentView(viewModel: RemindersViewModel) {
    var textFieldValue by remember { mutableStateOf("") }
    var reminders by remember {
        mutableStateOf(listOf<Reminder>(), policy = neverEqualPolicy())
    }
    val focusManager = LocalFocusManager.current
    val focusRequester = FocusRequester.Default
    var shouldFocusOnTextField by remember { mutableStateOf(false) }

    viewModel.onRemindersUpdated = { reminders = it }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp, bottom = 8.dp)
    ) {
        items(items = reminders) { item ->
            val onItemClick = {
                focusManager.clearFocus()
                viewModel.markReminder(id = item.id, isCompleted = !item.isCompleted)
            }
            ReminderItem(
                title = item.title,
                isCompleted = item.isCompleted,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = true, onClick = onItemClick)
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
        item {
            val onSubmit = {
                viewModel.createReminder(title = textFieldValue)
                textFieldValue = ""
                shouldFocusOnTextField = true
            }
            NewReminderTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                onSubmit = onSubmit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(reminders) {
                if (shouldFocusOnTextField) {
                    focusRequester.requestFocus()
                    shouldFocusOnTextField = false
                }
            }
        }
    }
}

@Composable
private fun ReminderItem(
    title: String,
    isCompleted: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        RadioButton(
            selected = isCompleted,
            onClick = null
        )
        Text(
            text = title,
            style = if (isCompleted) {
                MaterialTheme.typography.body1.copy(
                    textDecoration = TextDecoration.LineThrough,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                )
            } else {
                MaterialTheme.typography.body1
            },
            modifier = Modifier.padding(8.dp)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NewReminderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Add a new reminder here") },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { onSubmit() }
        ),
        modifier = modifier
            .onPreviewKeyEvent { event: KeyEvent ->
                if (event.key == Key.Enter) {
                    onSubmit()
                    return@onPreviewKeyEvent true
                }
                false
            }
    )
}

@Preview
@Composable
private fun RemindersViewPreview() {
    RemindersView {
    }
}
