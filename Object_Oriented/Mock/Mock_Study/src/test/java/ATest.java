import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ATest {
    private A a;

    @BeforeEach
    public void setUp() {
        a = new A(13);

    }


    @Test
    @DisplayName("isOlder을 실행했을 때, 객체의 age 보다 크면 true 반환")
    void isOlder_23() {
      assertThat(a.isOlder(23)).isTrue();
    }

    @Test
    @DisplayName("isOlder을 실행했을 때, 객체의 age 보다 작으면 false 반환")
    void isOlder_10() {
        assertThat(a.isOlder(10)).isFalse();
    }

    @Test
    @DisplayName("isOlder을 실행했을 때, 객체의 age 보다 작으면 false 반환")
    void isOlder_3() {
        assertThat(a.isOlder(3)).isFalse();
    }




    @ParameterizedTest
    @DisplayName("isOlder을 실행했을 때, 객체의 age 보다 큰 나이가 들어가면 true 반환, 그렇지 않으면 false 반환 ")
    @CsvSource(value = {"23,true", "10,false", "3,false"})
    void isOrder(int age, boolean expect) {
        assertThat(a.isOlder(age)).isEqualTo(expect);
    }


}