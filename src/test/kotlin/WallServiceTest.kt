import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

val service = WallService

class WallServiceTest {

    // метод очистки массива записей и обнуления id
    @Before //
    fun clear() {
        service.clear()
    }

    // тест метода добавления постов
    @Test
    fun add() {
        val post = Post(0)
        val result = service.add(post)
        assertEquals(Post(1) ,result)
    }

    // тест метода обновления постов на правду
    @Test
    fun updateTrue() {
        val post = Post(0)
        service.add(post)
        val result = service.update(Post(1,text = "upgradeText"))
        assertEquals(true, result)
    }

    // тест метода обновления постов на ложь
    @Test
    fun updateFalse() {
        val result = service.update(Post(1,text = "upgradeText"))
        assertEquals(false, result)
    }
}