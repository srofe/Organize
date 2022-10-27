import SwiftUI
import shared

struct AboutListView: View {
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        var result: [RowItem] = [
            RowItem(title: "Operating System", subtitle: "\(platform.osName) \(platform.osVersion)"),
            RowItem(title: "Device", subtitle: platform.deviceModel),
            RowItem(title: "CPU", subtitle: platform.cpuType)
        ]
        if let screen = platform.screen {
            let width = min(screen.width, screen.height)
            let height = max(screen.width, screen.height)
            result.append(RowItem(title: "Display", subtitle: "\(width)x\(height) @\(screen.density)"))
        }

        return result
    }()

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

    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
        AboutListView()
    }
}
