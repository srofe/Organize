//
//  ReminderItem.swift
//  iosApp
//
//  Created by Simon Rofe on 28/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ReminderItem: View {
    let title: String
    let isCompleted: Bool

    var body: some View {
        HStack {
            Image(systemName: isCompleted ? "largecircle.fill.circle" : "circle")
                .imageScale(.large)
                .foregroundColor(isCompleted ? .accentColor : .secondary)
            Text(title)
                .font(.body)
                .strikethrough(isCompleted, color: nil)
                .foregroundColor(isCompleted ? .secondary : .primary)
            Spacer()
        }
        .contentShape(Rectangle())
    }
}

struct ReminderItem_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ReminderItem(title: "New Item", isCompleted: false)
            ReminderItem(title: "Done Item", isCompleted: true)
        }
        .previewLayout(.sizeThatFits)
    }
}
