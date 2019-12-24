package Controller;

import GameModel.Card;
import GameModel.Game;
import GameModel.Hand;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void getTotalTest() throws IOException {
        Game game = new Game();
        game.setTotal(1000);
        Controller controller = new Controller(game);
        assertEquals(1000,controller.getTotal());

    }

    @Test
    public void checkPlayerNotBustedTest() throws IOException {
        Game game = new Game();
        game.dealHands();
        Controller controller = new Controller(game);
        Hand playerHand = game.getPlayerHand();
        playerHand.getHand().remove(0);
        playerHand.getHand().remove(0);
        playerHand.setValue(0);

        assertTrue(controller.checkPlayerNotBusted());

        game.setPlayerHand(new Card("clubs","Three"));
        game.setPlayerHand(new Card("spades","Eight"));


        assertTrue(controller.checkPlayerNotBusted());


        game.setPlayerHand(new Card("clubs","Ace"));
        game.setPlayerHand(new Card("diamonds","Ten"));
        game.setPlayerHand(new Card("spades","Queen"));
        game.setPlayerHand(new Card("hearts","King"));


        assertFalse(controller.checkPlayerNotBusted());

    }
//    @Test
//    public void startPressedTest() throws IOException {
//        Game game = new Game();
//        Controller controller = new Controller(game);
//        controller.initView();
//        controller.startPressed();
//        assertEquals(500,game.getTotal());
//
//
//    }

//    @Test
//    public void betPressedTest() throws IOException, AWTException {
//        Game game = new Game();
//        Controller controller = new Controller(game);
//        controller.initView();
//
//
//        controller.startPressed();
//        controller.betPressed(600);
//        assertEquals(500,game.getTotal());
//
//        controller.betPressed(100);
//        assertEquals(400,game.getTotal());
//
//        game.setTotal(500);
//        controller.betPressed(-100);
//        assertEquals(500,game.getTotal());
//
//        game.setTotal(500);
//        controller.betPressed(0);
//        assertEquals(500,game.getTotal());
//    }


//
//    @Test
//    public void pausePressedTest() throws IOException {
//        Game game = new Game();
//        Controller controller = new Controller(game);
//        controller.initView();
//        controller.betPressed(30);
//
//        assertEquals(3,controller.getRemainingPauses());
//
//        controller.pausePressed();
//        assertEquals(2,controller.getRemainingPauses());
//
//        controller.pausePressed();
//        assertEquals(1,controller.getRemainingPauses());
//
//        controller.pausePressed();
//        assertEquals(0,controller.getRemainingPauses());
//
//    }

    @Test
    public void checkWinTest() throws IOException {
        Game game = new Game();
        Controller controller = new Controller(game);
        game.dealHands();

        Hand playerHand = game.getPlayerHand();
        Hand dealerHand = game.getDealerHand();

        controller.stayPressed();

        playerHand.getHand().remove(0);
        playerHand.getHand().remove(0);
        playerHand.setValue(0);


        dealerHand.getHand().remove(0);
        dealerHand.getHand().remove(0);
        dealerHand.setValue(0);

        assertEquals(2,controller.checkWin());

        playerHand.drawCard(new Card("spades","Three"));
        playerHand.drawCard(new Card("clubs","Two"));
        dealerHand.drawCard(new Card("clubs","Five"));
        dealerHand.drawCard(new Card("diamonds","Six"));
        assertEquals(0,controller.checkWin());

        playerHand.drawCard(new Card("hearts","Nine"));
        assertEquals(1,controller.checkWin());

        dealerHand.drawCard(new Card("diamonds","Ten"));
        dealerHand.drawCard(new Card("diamonds","Five"));
        assertEquals(1,controller.checkWin());

        playerHand.drawCard(new Card("clubs","Seven"));
        assertEquals(1,controller.checkWin());

        playerHand.drawCard(new Card("spades","Ten"));
        playerHand.drawCard(new Card("diamonds","Ten"));
        playerHand.drawCard(new Card("hearts","Ten"));

        assertEquals(0,controller.checkWin());


    }

}
