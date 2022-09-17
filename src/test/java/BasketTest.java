import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasketTest {

    Basket basket = new Basket(new String[]{"Яблоко", "Помидор", "Апельсин", "Груша"}, new int[]{30, 50, 70, 40});

    //Тест 1. Попытка добавить товар с несуществующим индексом
    @Test
    @DisplayName("Тестирование добавления несуществующего товара")
    void addToCartTest1() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> basket.addToCart(5, 5));
    }

    //Тест 2. Добавление одного и того же товара дважды
    @Test
    @DisplayName("Тестирование количество добавленного дважды товара")
    void addToCartTest2() {
        basket.addToCart(1, 10);
        basket.addToCart(2, 10);
        basket.addToCart(1, 10);

        Assertions.assertEquals(20, basket.amountOfProductsInBasket[1]);
    }

    //Тест 3. Попытка добавить отрицательное количества товара
    @Test
    @DisplayName("Тестирования добавления отрицательного количества товара")
    void addToCartTest3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> basket.addToCart(5, -10));
    }
}