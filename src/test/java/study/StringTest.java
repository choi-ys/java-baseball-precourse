package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String Class에 대한 학습 테스트")
public class StringTest {

    private static final String SUBSTRING_SERVICE_UNDER_TEST = "(1,2)";
    private static final String CHAR_AT_SERVICE_UNDER_TEST = "abc";
    private static final String INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT = "String index out of range: %d";

    @ParameterizedTest
    @MethodSource()
    @DisplayName("split() : 주어진 문자열을 구분자를 기준으로 분리한 배열 검증")
    public void splitTest(String given, String[] expected) {
        // when
        String[] actual = given.split(",");

        // then
        Assertions.assertThat(actual).as("원소의 포함 여부 검증").contains(expected);
        Assertions.assertThat(actual).as("전체 원소의 일치 여부 검증").containsExactly(expected);
    }

    private static Stream<Arguments> splitTest() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1,", new String[]{"1"}),
                Arguments.of(",1", new String[]{"", "1"}),
                Arguments.of("", new String[]{""}),
                Arguments.of(",", new String[]{}),
                Arguments.of("1|2,", new String[]{"1|2"})
        );
    }

    @Test
    @DisplayName("substring() : 시작 Index와 종료 Index를 기준으로 자른 문자열 검증")
    public void substringTest() {
        // When
        String actual = SUBSTRING_SERVICE_UNDER_TEST.substring(1, 4);

        // Then
        assertThat(actual).as("1,2 반환 여부 확인").isEqualTo("1,2");
    }

    @Test
    @DisplayName("substring() : index 범위를 벗어나서 발생하는 IndexOutOfBoundsException 예외 검증")
    public void substringExceptionTest() {
        // When & Then
        assertThatThrownBy(() -> SUBSTRING_SERVICE_UNDER_TEST.substring(0, SUBSTRING_SERVICE_UNDER_TEST.length() + 1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT, SUBSTRING_SERVICE_UNDER_TEST.length() + 1));
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> SUBSTRING_SERVICE_UNDER_TEST.substring(SUBSTRING_SERVICE_UNDER_TEST.length(), 0))
                .withMessageContaining(String.format(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT, -SUBSTRING_SERVICE_UNDER_TEST.length()));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("charAt() : 주어진 문자열의 특정 Index 위치의 문자 반환 여부 검증")
    public void charAtTest(String given, int index, char expected) {
        // When
        char actual = given.charAt(index);

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> charAtTest() {
        return Stream.of(
                Arguments.of(CHAR_AT_SERVICE_UNDER_TEST, 0, 'a'),
                Arguments.of(CHAR_AT_SERVICE_UNDER_TEST, 1, 'b'),
                Arguments.of(CHAR_AT_SERVICE_UNDER_TEST, 2, 'c')
        );
    }

    @Test
    @DisplayName("chatAt() : index 범위를 벗어나서 발생하는 IndexOutOfBoundsException 예외 검증")
    public void chatAtExceptionTest() {
        // When & Then
        assertThatThrownBy(() -> CHAR_AT_SERVICE_UNDER_TEST.charAt(CHAR_AT_SERVICE_UNDER_TEST.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT, CHAR_AT_SERVICE_UNDER_TEST.length()));
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> CHAR_AT_SERVICE_UNDER_TEST.charAt(CHAR_AT_SERVICE_UNDER_TEST.length()))
                .withMessageMatching(String.format(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT, CHAR_AT_SERVICE_UNDER_TEST.length()));
    }
}
