import java.util.Scanner

class MenuHandler {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun getArchives(): List<Archive> = archives

    fun getUserInput(): String {
        return scanner.nextLine().trim()
    }

    fun createArchive() {
        println("Введите название архива:")
        val name = scanner.nextLine().trim()
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Название архива не может быть пустым!")
        }
    }

    fun showNoteMenu(archive: Archive) {
        NoteMenu(this, archive).showNoteMenu()
    }
}
