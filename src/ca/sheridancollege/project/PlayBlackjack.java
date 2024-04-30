/**
 * SYST 17796 - Group 4 - The Runtime Terrors
 */
package ca.sheridancollege.project;

/**
 * The main class to play Blackjack.
 * @author Karan Boparai, 2020
 * @author Zubear Nassimi, 2020
 * @author Aiden Janey, 2020
 * @author Christina Kwamie, 2020
 */

import java.util.*;

public class PlayBlackjack 
{
  static Scanner input = new Scanner(System.in);
  static ArrayList<Player> players = new ArrayList<>();
  static Dealer dealer = Dealer.getInstance();
  static Hand dealerHand = new Hand();
  private static int numOfPlayers;
  private static int numOfRounds;

  public static void main (String [] args)
  {
    setupGame();
    dealer.setHand(dealerHand);
    for (int i = 0; i < numOfRounds; i++)
    {
      playRound();

      System.out.println("End of Round " + (i + 1));
      for (Player player : players)
      {
        player.printResult();
      }
    }
  }

  public static void playRound ()
  {
    dealer.createDeck();
    dealer.dealTable(players);
    dealer.firstCard();
    playerTurns();
    dealerTurn();
    checkWin();
  }

  public static void setupGame()
  {
    System.out.println("Hello!, Welcome to Blackjack, How many players are there?");
    do
    {
      numOfPlayers = input.nextInt();
    }
    while (numOfPlayers == 0);
    System.out.println("How many rounds would you like to play?");
    do
    {
      numOfRounds = input.nextInt();
    }
    while (numOfRounds == 0);

    for (int i = 0;  i < numOfPlayers; i++)
    {
      int playerID = i + 1;
      System.out.println("Player " + playerID + ", What is your name?");
      String name = input.next();
      Hand playerHand = new Hand();
      players.add(new Player(playerID, name, playerHand));
    }
  }

  public static void checkWin()
  {
    for (Player player : players)
    {
      int playerTotal = player.hand.currentTotal();
      int dealerTotal = dealer.hand.currentTotal();

      if (playerTotal < 22 && dealerTotal < 22 && playerTotal > dealerTotal)
      {
        System.out.println(player.toString() + ", You won!");
        player.addWin();
      }
      else if (playerTotal < 22 && dealerTotal > 21)
      {
        System.out.println(player.toString() + ", You won!");
        player.addWin();
      }
      else if (playerTotal < 22 && dealerTotal < 22 && playerTotal == dealerTotal)
      {
        System.out.println(player.toString() + ", You tied");
        player.addTie();
      }
      else
      {
        System.out.println(player.toString() + ", You lost");
        player.addLoss();
      }
    }
  }

  public static void playerTurns()
  {
    for (Player player : players)
    {
      System.out.println(player.toString());
      player.hand.currentHand();
      while (player.hand.checkBlackjack() == false && player.hand.checkBust() == false)
      {
        System.out.println("Would you like to hit or stand?");
        System.out.println("Press 1 for hit or 2 for stand.");
        int hitOrStand = input.nextInt();
        if (hitOrStand == 1)
        {
          player.hand.addCard(dealer.dealCard());
          player.hand.currentHand();
        }
        else
        {
          break;
        }
      }
      if (player.hand.checkBlackjack() == true)
      {
        System.out.println("You got Blackjack!, you cannot hit anymore");
      }
      if (player.hand.checkBust() == true)
      {
        System.out.println("You bust out, better luck next time!");
      }
    }
  }

  public static void dealerTurn()
  {
    dealer.fullHand();
    while (dealer.hand.checkBlackjack() == false && dealer.hand.checkBust() == false)
    {
      if (dealer.checkDealerDraw() == true)
      {
        System.out.println("Dealer must draw");
        dealer.hand.addCard(dealer.dealCard());
        dealer.fullHand();
      }
      else
      {
        System.out.println("Dealer does not need to draw anymore, and they stand");
        System.out.println("Dealer hand is worth " + dealer.hand.currentTotal());
        break;
      }
    }
    if (dealer.hand.checkBlackjack() == true)
    {
      System.out.println("Dealer has Blackjack!");
    }
    if (dealer.hand.checkBust() == true)
    {
      System.out.println("Dealer has bust");
    }
  }
}
