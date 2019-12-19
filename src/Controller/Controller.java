package Controller;

import GUI.View;
import GameModel.Game;

public class Controller {

    private Game game_model;
    private View game_view;


    public Controller(Game game_model, View game_view) {
        this.game_model = game_model;
        this.game_view = game_view;
    }

    public View getGame_view() {
        return game_view;
    }

    public void setGame_view(View game_view) {
        this.game_view = game_view;
    }
}
