package baseball;

import utils.InputUtils;

public class Application {
    public static void main(String[] args) {
//        final Scanner scanner = new Scanner(System.in);

        do {
            Game game = new Game();
            int size = game.getSize();
            int number = InputUtils.userGuessInteraction(size);
            game.startGame(number);
        } while (InputUtils.userRestartInteraction() == 1);
    }
}