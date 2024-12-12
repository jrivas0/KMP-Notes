import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.screens.home.App


fun main() {
    application {
        Window(onCloseRequest = ::exitApplication, title = "My Notes") {
            App()
        }
    }
}
