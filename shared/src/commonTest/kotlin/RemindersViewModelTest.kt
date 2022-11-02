import com.poddlybonk.organize.presentation.RemindersViewModel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class RemindersViewModelTest {
    private lateinit var viewModel: RemindersViewModel

    @BeforeTest
    fun setup() {
        viewModel = RemindersViewModel()
    }

    @Test
    fun testCreatingReminder() {
        val title = "New Title"
        viewModel.createReminder(title)
        val count = viewModel.reminders.count {
            it.title == title
        }
        assertTrue(
            actual = count == 1,
            message = "Reminder with title: $title wasn't created."
        )
    }

    @Test
    fun testToggleReminderItem() {
        val title = "New Item"
        viewModel.createReminder(title)
        val item = viewModel.reminders.first()
        viewModel.markReminder(id = item.id, isCompleted = true)
        assertTrue(
            actual = viewModel.reminders.first().isCompleted,
            message = "Reminder with title: $title should be completed."
        )
    }
}