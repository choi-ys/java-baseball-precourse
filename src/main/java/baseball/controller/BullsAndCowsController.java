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
            Computer computer = new ComputerService().generateComputer();
            new RefereeService().verify(computer);
            gameStatus = isNew();
        }
    }

    // TODO : 게임 재 시작 입력값 유효성 검사
    public GameStatus isNew() {
        PrintGuideMessage.printContinueGameMessage();
        int newGameStatus = Integer.parseInt(Console.readLine());
        return newGameStatus == 1 ? GameStatus.ON : GameStatus.EXIT;
    }
}
