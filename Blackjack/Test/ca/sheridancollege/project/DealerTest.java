package ca.sheridancollege.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void checkDealerDrawOn0()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        boolean expResult = true;
        boolean result = dealer.checkDealerDraw();
        assertEquals(expResult, result);
    }

    @Test
    void checkDealerDrawOn17()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Six, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = false;
        boolean result = dealer.checkDealerDraw();
        assertEquals(expResult, result);
    }

    @Test
    void checkDealerDrawOn22()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Ace, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = false;
        boolean result = dealer.checkDealerDraw();
        assertEquals(expResult, result);
    }
}