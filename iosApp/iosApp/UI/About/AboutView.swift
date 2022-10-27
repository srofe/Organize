//
//  AboutView.swift
//  iosApp
//
//  Created by Simon Rofe on 26/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct AboutView: View {
    @Environment(\.dismiss) private var dismiss

    var body: some View {
        NavigationView {
            Text("Hello World!")
                .navigationTitle("About Device")
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
