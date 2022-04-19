package baseball.service;

import baseball.constants.NumberBoundary;
import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.constants.NumberBoundary.COUNT;
import static baseball.constants.NumberBoundary.START_INCLUSIVE;

public class ComputerService {
    public Computer generateComputer() {
        return new Computer(uniqueRandomNumbers());
    }

    private List<Integer> uniqueRandomNumbers() {
        Set<Integer> uniqueNumberSet = new LinkedHashSet();
        while (uniqueNumberSet.size() != COUNT) {
            int generateNumber = generateNumber();
            NumberValidator.numberBoundaryValidate(generateNumber);
            uniqueNumberSet.add(generateNumber);
        }
        return new ArrayList<>(uniqueNumberSet);
    }

    private static int generateNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, NumberBoundary.END_INCLUSIVE);
    }
}
