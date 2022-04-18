package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.PrintGuideMessage;

import java.util.List;

public class RefereeService {

    public void verify(Computer computer) {
        List<Integer> computerNumbers = computer.getComputerNumbers();

        boolean exitCondition = false;
        while (!exitCondition) {
            PlayerService playerService = new PlayerService();
            PrintGuideMessage.printInputMessage();
            Player player = playerService.generatePlayer();
            List<Integer> playerNumbers = player.getPlayerNumbers();

            isNoting(computerNumbers, playerNumbers);
            int ballCount = countingBall(computerNumbers, playerNumbers);
            int strikeCount = countingStrike(computerNumbers, playerNumbers);
            exitCondition = PrintGuideMessage.inGameMessage(ballCount, strikeCount);
        }
    }

    public int countingStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            strikeCount += verifyStrike(computerNumbers.get(i), playerNumbers.get(i));
        }
        return strikeCount;
    }

    private int verifyStrike(Integer computerNumber, Integer playerNumber) {
        return computerNumber == playerNumber ? 1 : 0;
    }

    public int countingBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
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

    // 각자리 비교
    private int verifyBallInnerDepth(int computerNumber, int computerIndex, int playerNumber, int playerIndex) {
        return (computerIndex != playerIndex && computerNumber == playerNumber) ? 1 : 0;
    }

    public void isNoting(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int notingCount = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            notingCount += verifyNoting(computerNumbers, playerNumbers.get(i));
        }

        if (notingCount == 3) {
            PrintGuideMessage.notingMessage();
        }
    }

    public int verifyNoting(List<Integer> computerNumbers, int playerNumber) {
        return !computerNumbers.contains(playerNumber) ? 1 : 0;
    }
}
