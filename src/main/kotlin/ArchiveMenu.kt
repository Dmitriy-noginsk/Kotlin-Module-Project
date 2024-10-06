class ArchiveMenu(private val menuHandler: MenuHandler) {

    fun showArchiveMenu() {
        while (true) {
            println("Добро пожаловать в приложение 'Заметки'")
            val archives = menuHandler.getArchives()
            println("0. Создать архив")
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("${archives.size + 1}. Выйти из программы")

            when (val input = menuHandler.getUserInput()) {
                "0" -> menuHandler.createArchive()
                in archives.indices.map { (it + 1).toString() } -> menuHandler.showNoteMenu(archives[input.toInt() - 1])
                (archives.size + 1).toString() -> return
                else -> println("Неправильный ввод, попробуйте еще раз.")
            }
        }
    }
}
