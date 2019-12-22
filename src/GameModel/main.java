package GameModel;

import Controller.Controller;
import GUI.StartView;
import GUI.View;

import java.io.IOException;


public class main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Controller controller = new Controller(game);
    }
}