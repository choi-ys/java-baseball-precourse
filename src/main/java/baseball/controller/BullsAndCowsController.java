package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.service.ComputerService;
import baseball.service.RefereeService;
import baseball.view.PrintGuideMessage;
import camp.nextstep.edu.missionutils.Console;

public class BullsAndCowsController {

    public void run() {
        GameStatus gameStatus = GameStatus.ON;
        while (!gameStatus.equals(GameStatus.EXIT)) {
            ComputerService computerService = new ComputerService();
            Computer computer = computerService.generateComputer();
            RefereeService refereeService = new RefereeService();
            refereeService.verify(computer);
            gameStatus = isNew();
        }
    }

    public GameStatus isNew() {
        PrintGuideMessage.printCorrectAnswerMessage();
        PrintGuideMessage.printContinueGameMessage();
        int newGameStatus = Integer.parseInt(Console.readLine());
        return newGameStatus == 1 ? GameStatus.ON : GameStatus.EXIT;
    }
}
