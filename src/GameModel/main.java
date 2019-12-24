package GameModel;

import Controller.Controller;

import java.io.IOException;


public class main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Controller controller = new Controller(game);
        controller.initView();
    }
}