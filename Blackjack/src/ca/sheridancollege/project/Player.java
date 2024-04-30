/**
 * SYST 17796 - Group 4 - The Runtime Terrors
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author Karan Boparai, 2020
 * @author Zubear Nassimi, 2020
 * @author Aiden Janey, 2020
 * @author Christina Kwamie, 2020
 */

import java.util.*;

public class Player 
{
    private int playerID;
    private String name;
    private int winCount = 0;
    private int tieCount = 0;
    private int lossCount = 0;
    Hand hand;



    public Player(int playerID, String name, Hand hand)
    {
        this.playerID = playerID;
        this.name = name;
        this.hand = hand;
    }

    public void addWin()
    {
        winCount++;
    }

    public void addTie()
    {
        tieCount++;
    }

    public void addLoss()
    {
        lossCount++;
    }

    public void printResult()
    {
        System.out.println ("Player " + (playerID) + ": " + name + ": " + winCount + " win(s), " + tieCount + " tie(s) and " + lossCount + " loss(es)");
    }
    public String toString()
    {
        return "Player " + (playerID) + ": " + name;
    }
}
