package ui.screens.home


import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import data.Note


@Composable
@Preview
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit): Unit {


    MaterialTheme {
        Scaffold(
            topBar = { TopBar(onFilterClick = vm::onFilterClick) },
            floatingActionButton = {
                FloatingActionButton(onClick = { onNoteClick(Note.NEW_NOTE) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                if (vm.state.loading) {
                    CircularProgressIndicator()
                }

                vm.state.filteredNotes?.let {notes ->
                    NotesList(notes = notes,
                        onNoteClick = { onNoteClick(it.id) }
                    )

                }
            }


        }
    }
}
