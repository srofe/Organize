//
// Created by Simon Rofe on 31/10/2022.
// Copyright (c) 2022 orgName. All rights reserved.
//

import Combine
import shared

final class RemindersViewModelWrapper: ObservableObject {
    let viewModel = RemindersViewModel()
    @Published private(set) var reminders: [Reminder] = []

    init() {
        viewModel.onRemindersUpdated = { [weak self] items in
            self?.reminders = items
        }
    }
}
