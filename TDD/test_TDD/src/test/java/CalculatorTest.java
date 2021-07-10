import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(1,2);

    @BeforeEach
    void setUp() {
        calculator = new Calculator(1, 2);
    }

    @Test
    @DisplayName("add 함수를 위한 테스트 코드 입니다.")
    void add() {

        assertThat(calculator.add(1,2)).isEqualTo(3);

    }

    @Test
    @DisplayName("sub 함수를 위한 테스트 코드 입니다.")
    void sub() {

        assertThat(calculator.sub(10,5)).isEqualTo(5);
    }

    @Test
    @DisplayName(" div 함수를 위한 테스트 코드 입니다.")
    void div() {

        assertThat(calculator.div(6,2)).isEqualTo(3);
    }


    @Test
    @DisplayName("mul 함수를 위한 테스트 코드 입니다.")
    void mul() {

        assertThat(calculator.mul(2,5)).isEqualTo(10);

    }

}