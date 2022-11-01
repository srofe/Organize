//
//  AboutView.swift
//  iosApp
//
//  Created by Simon Rofe on 26/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

extension AboutViewModel: ObservableObject {}

struct AboutView: View {
    @Environment(\.dismiss) private var dismiss
    @StateObject private var viewModel = AboutViewModel()

    var body: some View {
        NavigationView {
            AboutListView(items: viewModel.items)
                .navigationTitle(viewModel.title)
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
}

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView()
    }
}
