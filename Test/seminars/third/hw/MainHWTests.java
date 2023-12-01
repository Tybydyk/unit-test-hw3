package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class MainHWTests {

    MainHW mainhw;

    @BeforeEach
    void setup(){
        mainhw = new MainHW();
    }

    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
    @Test
    void OddNumberTest(){

        boolean result = mainhw.evenOddNumber(7);

        assertFalse(result);
    }

    @Test
    void evenNumberTest(){

        boolean result = mainhw.evenOddNumber(12);

        assertTrue(result);
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%
    @ParameterizedTest
    @CsvSource({"24", "101"})
    void numberIsNotInTheRange(int num) {

        boolean result = mainhw.numberInInterval(num);

        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"25", "100"})
    void numberIsInTheRange(int num) {

        boolean result = mainhw.numberInInterval(num);

        assertTrue(result);
    }
}
