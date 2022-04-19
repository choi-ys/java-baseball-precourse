package baseball.service;

import baseball.model.Computer;
import baseball.model.VerifyType;
import baseball.view.PrintGuideMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RefereeService {
    public void verify(Computer computer) {
        List<Integer> computerNumbers = computer.getComputerNumbers();

        boolean exitCondition = false;
        while (!exitCondition) {
            PrintGuideMessage.printInputMessage();
            List<Integer> playerNumbers = new PlayerService().generatePlayer().getPlayerNumbers();
            Map<VerifyType, Integer> countingResultMap = getVerifyTypeIntegerMap(computerNumbers, playerNumbers);
            PrintGuideMessage.inGameMessage(countingResultMap);
            exitCondition = isContinue(countingResultMap.get(VerifyType.STRIKE));
        }
    }

    private Map<VerifyType, Integer> getVerifyTypeIntegerMap(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        Map<VerifyType, Integer> countingResultMap = new LinkedHashMap<>();
        countingResultMap.put(VerifyType.NOTHING, countingNothing(computerNumbers, playerNumbers));
        countingResultMap.put(VerifyType.BALL, countingBall(computerNumbers, playerNumbers));
        countingResultMap.put(VerifyType.STRIKE, countingStrike(computerNumbers, playerNumbers));
        return countingResultMap;
    }

    private boolean isContinue(int strikeCount) {
        return strikeCount == 3 ? true : false;
    }

    private int countingStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            strikeCount += verifyStrike(computerNumbers.get(i), playerNumbers.get(i));
        }
        return strikeCount;
    }

    private int verifyStrike(Integer computerNumber, Integer playerNumber) {
        return computerNumber == playerNumber ? 1 : 0;
    }

    private int countingBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            ballCount += verifyBall(computerNumbers.get(i), playerNumbers, i);
        }
        return ballCount;
    }

    private int verifyBall(int computerNumber, List<Integer> playerNumbers, int computerIndex) {
        int ballCount = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            ballCount += verifyBallInnerDepth(computerNumber, computerIndex, playerNumbers.get(i), i);
        }
        return ballCount;
    }

    private int verifyBallInnerDepth(int computerNumber, int computerIndex, int playerNumber, int playerIndex) {
        return (computerIndex != playerIndex && computerNumber == playerNumber) ? 1 : 0;
    }

    private int countingNothing(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int nothingCount = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            nothingCount += verifyNothing(computerNumbers, playerNumbers.get(i));
        }

        return nothingCount;
    }

    private int verifyNothing(List<Integer> computerNumbers, int playerNumber) {
        return !computerNumbers.contains(playerNumber) ? 1 : 0;
    }
}
