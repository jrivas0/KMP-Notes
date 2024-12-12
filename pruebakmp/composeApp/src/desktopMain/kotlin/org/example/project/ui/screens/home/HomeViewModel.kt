package ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.Filter
import data.Note
//import data.fakeNotes
import data.remote.NotesRepository
import data.remote.notesClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

operator fun <T> StateFlow<T>.getValue(owner:Any?, property: KProperty<*>): T = this.value
operator fun <T> MutableStateFlow<T>.setValue(owner:Any?, property: KProperty<*>, newValue:T) {
    this.value = newValue
}

class HomeViewModel(private val scope: CoroutineScope) {

   var state by mutableStateOf(UiState())
    private set

    init {
        loadNotes()
        println("notas cargadas")
    }

    private fun loadNotes() {
        scope.launch{
            state =   UiState(loading = true)
            val response = NotesRepository.getAll()
            state = UiState(notes = response)

        }
    }

    fun onFilterClick(filter: Filter) {
        state = state.copy(filter = filter)
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All
    ){
        val filteredNotes get() = when(filter){
            Filter.All -> notes
            is Filter.ByType -> notes?.filter { it.type == filter.type }
        }
    }
}