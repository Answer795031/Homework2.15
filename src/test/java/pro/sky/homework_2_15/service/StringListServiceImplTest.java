package pro.sky.homework_2_15.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pro.sky.homework_2_15.exception.ElementNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StringListServiceImplTest {

    private final String[] testList = new String[]{};

    private final StringListServiceImpl stringListService = new StringListServiceImpl(testList);

    @Test
    void add_item_success() {

        // ожидаемый результат
        String expectedMessage = "item";

        // фактический результат
        String actualMessage = stringListService.add("item");

        // сравнение результатов
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void add_index_success() {

        // ожидаемый результат
        String expectedMessage = "item";

        // фактический результат
        String actualMessage = stringListService.add(0, "item");

        // сравнение результатов
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void add_index_IndexOutOfBoundsException() {

        // ожидаемый результат
        String expectedMessage = "Ошибка! Индекс выходит за пределы размера списка!";

        // фактический результат
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringListService.add(5, "item")
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void set() {

        stringListService.add("one");

        // ожидаемый результат
        String expectedMessage = "item";

        // фактический результат
        String actualMessage = stringListService.set(0, "item");

        // сравнение результатов
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void set_IndexOutOfBoundsException() {

        stringListService.add("one");

        // ожидаемый результат
        String expectedMessage = "Ошибка! Индекс выходит за пределы размера списка!";

        // фактический результат
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringListService.set(2, "item")
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_item_success() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "item";

        // фактический результат
        String actualMessage = stringListService.remove("item");

        // сравнение результатов
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void remove_item_ElementNotFoundException() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "Такой элемент отсутствует!";

        // фактический результат
        Exception exception = assertThrows(
                ElementNotFoundException.class,
                () -> stringListService.remove("one")
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_index_success() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "item";

        // фактический результат
        String actualMessage = stringListService.remove(0);

        // сравнение результатов
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void remove_index_IndexOutOfBoundsException() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "Ошибка! Индекс выходит за пределы размера списка!";

        // фактический результат
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringListService.remove(2)
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_index_ElementNotFoundException() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "Такой элемент отсутствует!";

        // фактический результат
        Exception exception = assertThrows(
                ElementNotFoundException.class,
                () -> stringListService.remove("one")
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void contains_success() {

        stringListService.add("item");

        // ожидаемый результат
        boolean expectedStatus = true;

        // фактический результат
        boolean actualStatus = stringListService.contains("item");

        // сравнение результатов
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void contains_fault() {

        stringListService.add("item");

        // ожидаемый результат
        boolean expectedResult = false;

        // фактический результат
        boolean actualResult = stringListService.contains("ITEM");

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void indexOf_success() {

        stringListService.add("item");

        // ожидаемый результат
        int expectedResult = 0;

        // фактический результат
        int actualResult = stringListService.indexOf("item");

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void indexOf_fault() {

        stringListService.add("item");

        // ожидаемый результат
        int expectedResult = -1;

        // фактический результат
        int actualResult = stringListService.indexOf("ITEM");

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastIndexOf_success() {

        stringListService.add("item");
        stringListService.add("one");
        stringListService.add("item");

        // ожидаемый результат
        int expectedResult = 2;

        // фактический результат
        int actualResult = stringListService.lastIndexOf("item");

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastIndexOf_fault() {

        stringListService.add("item");
        stringListService.add("one");
        stringListService.add("item");

        // ожидаемый результат
        int expectedResult = -1;

        // фактический результат
        int actualResult = stringListService.lastIndexOf("ITEM");

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void get() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedResult = "item";

        // фактический результат
        String actualResult = stringListService.get(0);

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void get_IndexOutOfBoundsException() {

        stringListService.add("item");

        // ожидаемый результат
        String expectedMessage = "Ошибка! Индекс выходит за пределы размера списка!";

        // фактический результат
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> stringListService.get(1)
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void equals_success() {

        stringListService.add("Item");
        stringListService.add("one");
        stringListService.add("RED");

        String[] comparingList = new String[]{"Item", "one", "RED"};

        // ожидаемый результат
        boolean expectedResult = true;

        // фактический результат
        boolean actualResult = stringListService.equals(comparingList);

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void equals_fault() {

        stringListService.add("RED");
        stringListService.add("Item");
        stringListService.add("one");

        String[] comparingList = new String[]{"Item", "one", "RED"};

        // ожидаемый результат
        boolean expectedResult = false;

        // фактический результат
        boolean actualResult = stringListService.equals(comparingList);

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void equals_IllegalArgumentException() {

        stringListService.add("RED");
        stringListService.add("Item");
        stringListService.add("one");

        String[] comparingList = new String[]{"Item", "one", "RED"};

        // ожидаемый результат
        String expectedMessage = "Ошибка! Необходимо указать не пустой массив для сравнения!";

        // фактический результат
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> stringListService.equals(null)
        );

        // сравнение результатов
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void isEmpty_success() {

        // ожидаемый результат
        boolean expectedResult = true;

        // фактический результат
        boolean actualResult = stringListService.isEmpty();

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isEmpty_fault() {

        stringListService.add("item");

        // ожидаемый результат
        boolean expectedResult = false;

        // фактический результат
        boolean actualResult = stringListService.isEmpty();

        // сравнение результатов
        assertEquals(expectedResult, actualResult);
    }
}