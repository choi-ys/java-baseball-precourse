package baseball.model;

import baseball.service.ComputerService;
import baseball.service.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static baseball.constants.NumberBoundary.COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ComputerServiceTest {

    @Test
    @DisplayName("1~9 범위내에서 중복 없는 난수 생성 검증")
    public void generateComputerTest() {
        // Given
        ComputerService given = new ComputerService();

        // When
        Computer actual = given.generateComputer();

        // Then
        assertThat(actual.getComputerNumbers())
                .as("중복없는 3개의 난수 생성 여부 검증")
                .size()
                .isEqualTo(COUNT);
    }

    @DisplayName("입력 받은 값이 1~9 범위에 포함되는지 여부 검증")
    @ParameterizedTest
    @MethodSource
    public void isValidNumberTest(int given) {
        // When & Then
        NumberValidator.numberBoundaryValidate(given);
    }

    private static Stream<Arguments> isValidNumberTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(5),
                Arguments.of(6),
                Arguments.of(7),
                Arguments.of(8),
                Arguments.of(9)
        );
    }

    @DisplayName("1~9 범위를 벗어나는 입력값에 대한 예외 처리 검증")
    @ParameterizedTest
    @MethodSource
    public void isValidNumberTest_IllegalArgumentException(int given) {
        // Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NumberValidator.numberBoundaryValidate(given))
                .withMessageContaining("is invalid Number");
    }

    private static Stream<Arguments> isValidNumberTest_IllegalArgumentException() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(10),
                Arguments.of(Integer.MIN_VALUE),
                Arguments.of(Integer.MAX_VALUE)
        );
    }
}