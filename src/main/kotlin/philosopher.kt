import kotlin.random.Random

class Philosopher(val id: Int) {
    fun takeFork(forks: ArrayList<Fork>) {
        // Первоначально решение философа взять вилку (или слева, или справа)
        val isLeftFork = Random.nextBoolean()

        // Поиск вилок слева и справа от философа
        val leftFork = forks[id % forks.size]
        val rightFork = forks[(id + 1) % forks.size]

        // Левая вилка еще свободна и первоначальный выбор философа слева
        if (!leftFork.isChosen && isLeftFork) {
            leftFork.isChosen = true
            println("Философ ${id + 1} взял вилку слева и обедает")
            return
        }
        // Правая вилка еще свободна, но первоначальный выбор философа слева
        else if (!rightFork.isChosen) {
            rightFork.isChosen = true
            println("Философ ${id + 1} взял вилку справа и обедает")
            return
        }
        // Правая вилка еще свободна и первоначальный выбор философа справа
        else if (!rightFork.isChosen && !isLeftFork) {
            rightFork.isChosen = true
            println("Философ ${id + 1} взял вилку справа и обедает")
            return
        }
        // Левая вилка еще свободна, но первоначальный выбор философа справа
        else if (!leftFork.isChosen) {
            leftFork.isChosen = true
            println("Философ ${id + 1} взял вилку слева и обедает")
            return
        }

        // Если нет свободных вилос слева и справа, то философ думает
        println("Философ ${id + 1} размышляет")
    }
}