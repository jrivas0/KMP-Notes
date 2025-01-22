import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.getAppTitle
import org.example.project.ui.screens.home.App


fun main() {
    application {
        Window(onCloseRequest = ::exitApplication, title = getAppTitle()) {
            App()
        }
    }
}
