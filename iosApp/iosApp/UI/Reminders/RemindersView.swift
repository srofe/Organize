//
//  RemindersView.swift
//  iosApp
//
//  Created by Simon Rofe on 26/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RemindersView: View {
    @StateObject private var viewModelWrapper = RemindersViewModelWrapper()
    @State private var textFieldValue = ""
    @FocusState private var shouldFocusOnTextField: Bool

    var body: some View {
        List {
            if !viewModelWrapper.reminders.isEmpty {
                Section {
                    ForEach(viewModelWrapper.reminders, id: \.id) { item in
                        ReminderItem(title: item.title, isCompleted: item.isCompleted)
                                .onTapGesture {
                                    withAnimation {
                                        viewModelWrapper.viewModel.markReminder(id: item.id, isCompleted: !item.isCompleted)
                                        shouldFocusOnTextField = false
                                    }
                                }
                    }
                }
            }
            Section {
                NewReminderTextField(text: $textFieldValue) {
                    withAnimation {
                        viewModelWrapper.viewModel.createReminder(title: textFieldValue)
                        textFieldValue = ""
                        shouldFocusOnTextField = true
                    }
                }
                        .focused($shouldFocusOnTextField)
            }
        }
        .navigationTitle(viewModelWrapper.viewModel.title)
        .toolbar {
            ToolbarItemGroup(placement: .keyboard) {
                Spacer()
                Button("Done") {
                    shouldFocusOnTextField = false
                }
            }
        }
    }
}

struct RemindersView_Previews: PreviewProvider {
    static var previews: some View {
        RemindersView()
    }
}
