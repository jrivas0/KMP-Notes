package data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable

@Serializable
data class Note (val title: String, val description: String, val type: Type, val id: Long = NEW_NOTE) {
    companion object{
        const val NEW_NOTE = -1L
    }
    enum class Type { TEXT,AUDIO }

}

/* interface Callback{
    fun invoke(notes: List<Note>) // (List<Note>) -> Unit
} */

/*
val Note.Companion.fakeNotes get(): Flow<List<Note>> = flow {
    delay(2000)
    val notes = (0..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )

    }
    emit(notes)
}*/