class NoteDisplay(private val note: Note) {
    fun showNote() {
        println("Заметка: ${note.title}")
        println(note.content)
    }
}
