package GameModel;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void dealHandsTest() throws IOException {
        Game game = new Game();
        game.dealHands();

        assertEquals(2,game.getPlayerHand().getHand().size());
        assertEquals(2,game.getDealerHand().getHand().size());

    }

    @Test
    public void betTest() throws IOException {
        Game game = new Game();

        game.bet(100);
        assertEquals(400,game.getTotal());

        game.setTotal(500);
        game.bet(600);
        assertEquals(500,game.getTotal());

        game.bet(-100);
        assertEquals(500,game.getTotal());


        game.bet(99999);
        assertEquals(500,game.getTotal());

        game.bet(0);
        assertEquals(500,game.getTotal());
    }

    @Test
    public void addToTotalTest() throws IOException {
        Game game = new Game();

        game.addToTotal(1000);
        assertEquals(1500,game.getTotal());
    }

    @Test
    public void hitTest() throws IOException {
        Game game = new Game();
        game.dealHands();
        assertEquals(2,game.getPlayerHand().getHand().size());
        game.hit();
        assertEquals(3,game.getPlayerHand().getHand().size());
    }

    @Test
    public void setDealerHandTest() throws IOException {
        Game game = new Game();
        game.dealHands();
        if(game.getDealerHand().getValue() > 16){
            game.setDealerHand();
            assertEquals(2,game.getDealerHand().getHand().size());
        }

    }

}
