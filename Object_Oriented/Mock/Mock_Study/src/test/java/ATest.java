import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ATest {
    private A a;

    @BeforeEach
    public void setUp() {
        a = new A(13);

    }


    @ParameterizedTest
    @DisplayName("isOlder을 실행했을 때, 객체의 age 보다 큰 나이가 들어가면 true 반환, 그렇지 않으면 false 반환 ")
    @CsvSource(value = {"15,true", "1,false", "10,false"})
    void isOrder(int age, boolean expect) {
        assertThat(a.isOlder(age)).isEqualTo(expect);
    }


}