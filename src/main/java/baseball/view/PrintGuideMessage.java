package baseball.view;

import baseball.constants.GuideMessage;
import baseball.model.VerifyType;

import java.util.Map;

public class PrintGuideMessage {
    private static final String GAME_GUIDE_MESSAGE_FORMAT = "%d%s";

    public static void printInputMessage() {
        System.out.print(GuideMessage.INPUT_NUMBER_MESSAGE);
    }

    public static void printContinueGameMessage() {
        System.out.println(GuideMessage.CORRECT_ANSWER_MESSAGE);
        System.out.println(GuideMessage.CONTINUE_GAME_MESSAGE);
    }

    public static void inGameMessage(Map<VerifyType, Integer> countingResultMap) {
        if (countingResultMap.get(VerifyType.NOTHING) == 3) {
            System.out.println(VerifyType.NOTHING.getDescription());
            return;
        }
        countingResultMap.remove(VerifyType.NOTHING);
        for (Map.Entry<VerifyType, Integer> entry : countingResultMap.entrySet()) {
            System.out.print(addMessage(entry.getKey().getDescription(), entry.getValue()) + " ");
        }
    }
    
    private static String addMessage(String type, int count) {
        if (count != 0) {
            return String.format(GAME_GUIDE_MESSAGE_FORMAT, count, type);
        }
        return "";
    }
}
