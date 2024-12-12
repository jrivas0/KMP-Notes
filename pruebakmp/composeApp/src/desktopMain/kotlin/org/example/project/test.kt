import data.Note
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ViewModel {
   /* private val _state: MutableStateFlow<Note> = MutableStateFlow(Note("title 1", "description 1", Note.Type.TEXT))
    val state:  StateFlow<Note> = _state.asStateFlow()

    suspend fun update(){
        var count = 1
        while (true){
            delay(2000)
            count++
            _state.value = Note("title $count","description $count", Note.Type.TEXT)
        }
    } */
   private val _state = MutableSharedFlow<Note>(replay = 2, extraBufferCapacity = 2, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val state = _state.asSharedFlow()

 /*   suspend fun update(){
        var count = 1
        while (true){
            delay(500)
            _state.emit(Note("title $count","description $count", Note.Type.TEXT))
            println("Emitting title $count")
            count++
        }
    } */

    fun update(callback: (Note) -> Unit){
        var count = 1
        while (true){
            Thread.sleep(500)
            callback(Note("title $count","description $count", Note.Type.TEXT))
            println("Emitting title $count")
            count++
        }
    }

}

fun ViewModel.updatesFlow(): Flow<Note> = callbackFlow {
    update { trySend(it) }
}

fun main(): Unit = runBlocking{

   /* val res = flow {
        emit(1)
        delay(400)
        emit(2)
        delay(400)
        emit(3)
        delay(400)
        emit(4)
    }.transform { //vuelve a emitir valores para cada uno de los que llegan
        if(it % 2 == 0) emit ("Item $it")
    }
    launch {
        res.collect {
            println(it)
        }
    }


    val flow1 = flowOf(1,2,3,4)
    val flow2 = flowOf("a","b","c")

    flow1.zip(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    flow1.combine(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    //flow1.combine(flow2) { a, b -> "$a -> $b" }.toList()

    val flow3 = flow {
            emit(2)
        throw IllegalStateException("Exception message")
    }

    flow3.flowOn(Dispatchers.IO)//para cambiar el contexto del flow, debe hacerlo el consumidor
        .catch { throwable -> println(throwable.message)  }
        .collect {
        println(it)
    } */

   /* val viewModel = ViewModel()
    launch {
        viewModel.update()
    }
    delay(1100)
    viewModel.state.collect {
        delay(1000)
        println(it)
    } */

    val viewModel = ViewModel()
    launch(Dispatchers.Default) {
        viewModel.updatesFlow().collect{
            println(it)
        }
    }

}