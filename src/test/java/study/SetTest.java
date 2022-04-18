package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set : 크기에 대한 검증")
    public void setSizeTest() {
        // When
        final int setSize = numbers.size();

        // Then
        Assertions.assertThat(setSize).as("Set의 크기가 3인지 여부를 검증").isEqualTo(3);
    }

    @DisplayName("Set : 요소 포함 여부 검증")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setTest01(int given) {
        // when
        boolean actual = numbers.contains(given);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("Set : 요소 포함/미포함 여부 검증")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
    public void setTest02(String given, String expected) {
        // when
        boolean actual = numbers.contains(Integer.parseInt(given));

        // then
        Assertions.assertThat(actual).isEqualTo(Boolean.parseBoolean(expected));
    }
}
