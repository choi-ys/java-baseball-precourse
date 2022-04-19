package baseball.view;

import baseball.model.VerifyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author : choi-ys
 * @date : 2022/04/19 3:05 오후
 */
@DisplayName("게임 진행 안내 메세지 Test")
class PrintGuideMessageTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("게임 count에 따른 Hint Message 출력 Test")
    public void printInGameMessageTest(int notingCount, int ballCount, int strikeCount) {
        // When & Then
        Map<VerifyType, Integer> countingResultMap = new LinkedHashMap<>();
        countingResultMap.put(VerifyType.NOTHING, notingCount);
        countingResultMap.put(VerifyType.BALL, ballCount);
        countingResultMap.put(VerifyType.STRIKE, strikeCount);
        PrintGuideMessage.inGameMessage(countingResultMap);
    }

    private static Stream<Arguments> printInGameMessageTest() {
        return Stream.of(
                Arguments.of(3, 0, 0),
                Arguments.of(2, 0, 1),
                Arguments.of(1, 0, 2),
                Arguments.of(0, 0, 3),
                Arguments.of(2, 1, 0),
                Arguments.of(1, 2, 0),
                Arguments.of(0, 3, 0),
                Arguments.of(0, 2, 1),
                Arguments.of(0, 1, 2)
        );
    }
}