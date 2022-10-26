import SwiftUI

struct ContentView: View {
	@State private var shouldOpenAbout = false

	var body: some View {
        NavigationView {
            RemindersView()
                .toolbar {
                    ToolbarItem(placement: .bottomBar) {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .padding(8)
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutView()
                                .frame(
                                    idealWidth: 350,
                                    idealHeight: 450
                                )
                        }
                    }
                }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
