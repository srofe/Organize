//
//  NewReminderTextField.swift
//  iosApp
//
//  Created by Simon Rofe on 28/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct NewReminderTextField: View {
    @Binding var text: String
    var onCommit: () -> Void

    var body: some View {
        TextField(
            "Add new reminder here",
            text: $text,
            onEditingChanged: {_ in },
            onCommit: onCommit
        )
    }
}

struct NewReminderTextField_Previews: PreviewProvider {
    static var previews: some View {
        NewReminderTextField(text: .constant("")) {
        }
    }
}
