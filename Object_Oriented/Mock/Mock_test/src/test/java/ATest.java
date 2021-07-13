import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ATest {

    private A a;

    @BeforeEach
    void setup() {
        a = new A(13);
    }

    @Test
    @DisplayName("나이의 크기 비교")
    void isOrder() {
        assertThat(a.isOlder(23)).isEqualTo(true);
        assertThat(a.isOlder(3)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("나이가 많으면 True을 반환 그렇지 않으면 False 반환")
    @CsvSource(value = {"12,false","7,false","26,true"})
    void isOrder1(int age, boolean expect){
        assertThat(a.isOlder(age)).isEqualTo(expect);
    }
}