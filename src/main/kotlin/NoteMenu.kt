class NoteMenu(private val menuHandler: MenuHandler, private val archive: Archive) {

    fun showNoteMenu() {
        while (true) {
            println("Архив '${archive.name}'")
            val notes = archive.getNotes()
            println("0. Создать заметку")
            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
            println("${notes.size + 1}. Выйти назад")

            when (val input = menuHandler.getUserInput()) {
                "0" -> createNote()
                in notes.indices.map { (it + 1).toString() } -> showNoteDisplay(notes[input.toInt() - 1])
                (notes.size + 1).toString() -> return
                else -> println("Неправильный ввод, попробуйте еще раз.")
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = menuHandler.getUserInput()
        if (title.isNotEmpty()) {
            println("Введите содержание заметки:")
            val content = menuHandler.getUserInput()
            if (content.isNotEmpty()) {
                archive.addNote(Note(title, content))
                println("Заметка '$title' создана.")
            } else {
                println("Содержание заметки не может быть пустым!")
            }
        } else {
            println("Название заметки не может быть пустым!")
        }
    }

    private fun showNoteDisplay(note: Note) {
        NoteDisplay(note).showNote()
    }
}
