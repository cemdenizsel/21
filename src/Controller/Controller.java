package Controller;

import GUI.View;
import GameModel.Game;

public class Controller {

    private Game game;
    private View view;

    public Controller(Game game) {
        this.game = game;
    }
    public Controller(View view){
        this.view = view;
    }
    public Controller(Game game, View view){
        this.view = view;
        this.game = game;
    }


    public View getGameView() { return view; }

    public void setGameView(View view) { this.view = view; }

    public Game getGameModel(){ return game;}

}
