package ui.screens.home

import androidx.compose.runtime.*
import ui.screens.detail.Detail
import ui.screens.detail.DetailViewModel

sealed interface Route {
    object Home: Route
    data class Detail(val id: Long): Route
}

@Composable
fun App(){

    var route by remember { mutableStateOf<Route>(Route.Detail(-1))}
    val scope = rememberCoroutineScope()

    route.let {
        when(it){
            Route.Home -> Home(
                vm= HomeViewModel(scope),
                onNoteClick = { noteId-> route = Route.Detail(noteId)})
            is Route.Detail -> Detail(vm = DetailViewModel(scope, it.id), onClose = { route = Route.Home })
        }
    }

}

