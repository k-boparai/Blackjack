package ca.sheridancollege.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void checkBlackjackOn0()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        boolean expResult = false;
        boolean result = hand.checkBlackjack();
        assertEquals(expResult, result);
    }

    @Test
    void checkBlackjackOn21()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Ten, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = true;
        boolean result = hand.checkBlackjack();
        assertEquals(expResult, result);
    }

    @Test
    void checkBlackjackOn22()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Ace, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = false;
        boolean result = hand.checkBlackjack();
        assertEquals(expResult, result);
    }

    @Test
    void checkBustOn0()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        boolean expResult = false;
        boolean result = hand.checkBust();
        assertEquals(expResult, result);
    }

    @Test
    void checkBustOn21()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Ten, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = false;
        boolean result = hand.checkBust();
        assertEquals(expResult, result);
    }

    @Test
    void checkBustOn22()
    {
        Dealer dealer = Dealer.getInstance();
        Hand hand = new Hand();
        dealer.setHand(hand);
        Card card1 = new Card(Card.Name.Ace, Card.Suit.Diamonds);
        Card card2 = new Card(Card.Name.Ace, Card.Suit.Clubs);
        hand.addCard(card1);
        hand.addCard(card2);
        boolean expResult = true;
        boolean result = hand.checkBust();
        assertEquals(expResult, result);
    }
}