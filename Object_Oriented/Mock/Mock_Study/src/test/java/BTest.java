import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BTest {
    private A a;
    private B b;

    @BeforeEach
    void setUp() {
        a = mock(A.class);
        b = new B(a);

    }


    @Test
    @DisplayName("isOlderThanA a의 age를 비교하여 값이 true면 1반환")
    void isOlderThanA_1() {

        when(a.isOlder(anyInt())).thenReturn(true);
        assertThat(b.isOlderThanA()).isEqualTo(1);
    }

    @Test
    @DisplayName("isOlderThanA a의 age를 비교하여 값이 false면 0반환")
    void isOlderThanA_0() {
        when(a.isOlder(anyInt())).thenReturn(false);
        assertThat(b.isOlderThanA()).isEqualTo(0);
    }

    // TODO 아래 두 메서드 합치기.
    @ParameterizedTest
    @DisplayName("isOlderThanA를 실행했을 때, 객체의 age 보다 큰 나이가 들어가면 1 반환, 그렇지 않으면 0 반환")
    @CsvSource(value = {"true,1", "false,0"})
    void isOlderThanA_1_and_0(boolean result, int expect) {

        when(a.isOlder(anyInt())).thenReturn(result);
        assertThat(b.isOlderThanA()).isEqualTo(expect);

    }


    @Test
    @DisplayName("a.check 메서드가 3번 실행 되어야 한다.")
    void check() {
        b.check();
        verify(a, times(3)).check();

    }
}