import androidx.compose.runtime.MutableState
import ui.screens.home.HomeViewModel

fun MutableState<HomeViewModel.UiState>.update(produceValue: () -> HomeViewModel.UiState){
    this.value = produceValue()
}