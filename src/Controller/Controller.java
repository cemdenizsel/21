package Controller;

import GUI.View;

import GameModel.Game;

import javax.swing.*;
import java.io.*;

public class Controller {
    private Game game;
    private View view;
    private int playersValue;
    private int dealersValue;
    private int betAmount;
    private final int WIN = 1;
    private final int LOSE = 0;
    private final int TIE = 2;
    private File highscoreTxt;

    private int remainingPauses;

    private Timer timer;


    public Controller(Game game) {
        this.game = game;
        this.view = new View(this);

        highscoreTxt = new File("highscore.txt");

    }

    public int getTotal() {
        return game.getTotal();
    }

    public void startPressed() throws IOException {
        view.setToSessionView();

    }

    public void exitPressed() {
        System.exit(0);
    }

    public void withdrawPressed() throws FileNotFoundException, UnsupportedEncodingException {
       if(getHighestScore()<game.getTotal()){
           try {
               BufferedWriter br = new BufferedWriter(new FileWriter(highscoreTxt));
               br.write(""+game.getTotal());
               br.close();
           }catch (IOException ex){
               ex.printStackTrace();
           }
       }
        view.getStartView().updateTotal();
        view.setToStartView();
    }

    public void betPressed(int betAmount) throws IOException {
        remainingPauses = 3;
        this.betAmount = betAmount;
        if (betAmount > getTotal()) {
            JOptionPane.showMessageDialog(view, "You total is lower than your bet, Please lower your bet amount");
        }else if(betAmount <= 0){
            JOptionPane.showMessageDialog(view,"Please enter a positive number!!!");
        }
        else {
            game.bet(betAmount);
            game.dealHands();
            view.setToRoundView();
        }
    }


    public Game getGame() {
        return game;
    }

    public void hitPressed() {
        game.hit();
        playersValue = game.getPlayerHand().getValue();

    }

    public int checkWin() {

        if (playersValue > 21)
        {

            return LOSE;
        }
        else if (playersValue == 21 && dealersValue != 21)
        {
            game.addToTotal(betAmount * 2);
            return WIN;
        }
        else if (playersValue < 21 && dealersValue > 21)
        {
            game.addToTotal(betAmount * 2);
            return WIN;
        }
        else if (playersValue < 21 && dealersValue < 21 && playersValue > dealersValue)
        {
            game.addToTotal(betAmount * 2);
            return WIN;
        }
        else if (playersValue < 21 && dealersValue < 21 && dealersValue > playersValue)
        {
            return LOSE;
        }
        else if (playersValue == dealersValue)
        {
            return TIE;
        }
        else
        {
            return LOSE;
        }
    }

    public void gameTied() {
        game.addToTotal(betAmount);
        view.getSessionView().setTotalLabel();
        view.setToSessionView();
    }

    public boolean checkPlayerNotBusted(){
        return !(playersValue>21);
    }

    public void roundFinished(){
        view.getSessionView().setTotalLabel();
        view.setToSessionView();
    }

    public int stayPressed() {

        game.setDealerHand();
        dealersValue = game.getDealerHand().getValue();
        playersValue = game.getPlayerHand().getValue();

        return checkWin();

    }

    public void pausePressed() {
        remainingPauses--;
        timer = view.getRoundView().getTimer();
        timer.stop();

    }

    public void resumePressed() {
        timer.start();
    }


    public int getRemainingPauses(){
        return remainingPauses;
    }

    public int getHighestScore(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("highscore.txt"));
            return Integer.parseInt(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return 0;
    }

}


