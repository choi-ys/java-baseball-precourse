package baseball.service;

import baseball.constants.ErrorMessage;

import static baseball.constants.NumberBoundary.END_INCLUSIVE;
import static baseball.constants.NumberBoundary.START_INCLUSIVE;

public class NumberValidator {
    // 유효 범위 유효성 검사
    public static void numberBoundaryValidate(int generatedNumber) {
        if (!(generatedNumber >= START_INCLUSIVE && generatedNumber <= END_INCLUSIVE)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_BOUNDARY_MESSAGE);
        }
    }
}
