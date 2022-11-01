import SwiftUI
import shared

struct AboutListView: View {
    let items: [AboutViewModel.RowItem]

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundColor(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundColor(.primary)
                }
                    .padding(.vertical, 4)
            }
        }
    }
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
        AboutListView(items: [AboutViewModel.RowItem(title: "Title", subtitle: "Subtitle")])
    }
}
