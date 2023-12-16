import kotlin.random.Random

fun main() {
    // Бесконечный цикл для повторного ввода количества философов
    while (true) {
        // Ввод пользователем числа философов
        print("Введите числом количество философов за круглым столом: ")
        val countPhilosophers = readln().toIntOrNull()

        // Проверка введенного значения
        if (countPhilosophers == null || countPhilosophers <= 0) {
            println("Количество философов должно быть больше нуля")
            continue
        } else {
            // Создание списков для философов и вилок
            val philosophers = ArrayList<Philosopher>()
            val forks = ArrayList<Fork>()

            // Инициализация философов и вилок и добавление их в списки
            for (i in 0 until countPhilosophers) {
                philosophers.add(Philosopher(i))
                forks.add(Fork(i))
            }

            // Перемешивание философов в случайном порядке
            philosophers.shuffle(Random)

            // Вызов метода takeFork для каждого философа
            for (i in 0 until countPhilosophers) {
                philosophers[i].takeFork(forks)
            }
            println()
        }
    }
}