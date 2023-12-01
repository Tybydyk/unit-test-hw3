package seminars.third.coverage;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.
    SomeService someService;
    int[] numList;

    @BeforeEach
    void setup(){
        someService = new SomeService();
//        numList = new int[]{1, 2, 3, 4, 5, 6};
    }


    @Test
    void first6arrayShouldReturnTrue() {

        boolean result = someService.firstLast6(new int[]{1, 2, 3, 4, 5, 6});

        assertEquals(true, result);
    }

    @Test
    void firstNot6arrayShouldReturnFalse() {

        boolean result = someService.firstLast6(new int[]{1, 2, 3, 4, 5, 7});

        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"2000,0, 2000", "2000, 50, 1000", "2000, 100, 0"})
    void calculatedTotalWithDiscount(double amount, int discount, double total) {

        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(total); // обычная скидка
        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(total); // обычная скидка
        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(total); // обычная скидка
    }
    @Test
    void exceptionsTest(){
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

//    void multipleThreeNotFiveReturnsFizz(int n) {
//        // assertEquals...
//    }

}