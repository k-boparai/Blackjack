/**
 * SYST 17796 - Group 4 - The Runtime Terrors
 */
package ca.sheridancollege.project;

/**
 * Card class to create instances of for each card.
 * @author Karan Boparai, 2020
 * @author Zubear Nassimi, 2020
 * @author Aiden Janey, 2020
 * @author Christina Kwamie, 2020
 */

import java.util.*;

public class Card
{
    enum Suit
    {
      Hearts, Diamonds, Clubs, Spades
    };

    enum Name 
    {
      Ace (11), Two (2), Three (3), Four (4), Five (5), Six (6), Seven (7), Eight (8), Nine (9), Ten (10), Jack (10), Queen (10), King (10);

      public final int worth;

      private Name (int worth)
      {
        this.worth = worth;
      }
    };

    private Name name;
    private Suit  suit;

    
    public Card(Name name, Suit suit)
    {
        this.name   = name;
        this.suit   = suit;
    }

    public int value ()
    {
        return name.worth;
    }

    public String toString()
    {
      return name + " of " + suit + " which is worth " + name.worth;
    }
}