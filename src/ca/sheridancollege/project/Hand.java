/**
 * SYST 17796 - Group 4 - The Runtime Terrors
 */
package ca.sheridancollege.project;

/**
 * Bank class which will store and track chips used to wager.
 * @author Karan Boparai, 2020
 * @author Zubear Nassimi, 2020
 * @author Aiden Janey, 2020
 * @author Christina Kwamie, 2020
 */

import java.util.*;

public class Hand
{
    ArrayList<Card> hand = new ArrayList<>();
    private int total;

    public Hand ()
    {

    }

    public void addCard (Card card)
    {
        hand.add(card);
    }

    public void clearHand()
    {
        hand.clear();
    }

    public void currentHand ()
    {
        System.out.println("You have: ");
        for (Card card : hand)
        {
            System.out.println(card.toString());
        }
        System.out.println("Your hand is worth: " + currentTotal());
    }

    public int currentTotal ()
    {
        total = 0;
        for (Card card : hand)
        {
            total += card.value();
        }
        return total;
    }

    public boolean checkBlackjack()
    {
        if (currentTotal() == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkBust()
    {
        if (currentTotal()  > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
