package com.poddlybonk.organize.presentation

import com.poddlybonk.organize.data.RemindersRepository
import com.poddlybonk.organize.domain.Reminder

class RemindersViewModel : BaseViewModel() {
    private val repository = RemindersRepository()
    private val reminders: List<Reminder>
        get() = repository.reminders
    var onRemindersUpdated: ((List<Reminder>) -> Unit)? = null
        set(value) {
            field = value
            onRemindersUpdated?.invoke(reminders)
        }
    val title: String = "Reminders"

    fun createReminder(title: String) {
        val trimmed = title.trim()
        if (trimmed.isNotEmpty()) {
            repository.createReminder(title = trimmed)
            onRemindersUpdated?.invoke(reminders)
        }
    }

    fun markReminder(id: String, isCompleted: Boolean) {
        repository.markReminder(id = id, isCompleted = isCompleted)
        onRemindersUpdated?.invoke(reminders)
    }
}