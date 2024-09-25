package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author danielBajenov 991751839
 */ 
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1);
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]);
            magicHand[i] = c;
            
            System.out.println((i + 1) + ": " + c.getSuit() + ' ' + c.getValue());
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1-13, 1:Ace, 11:Jack, 12:Queen, 13:King):");
        int userValue = scanner.nextInt();

        System.out.println("Pick a suit (0: Hearts, 1: Diamonds, 2: Spades, 3: Clubs):");
        int suitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[suitIndex];

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        Card luckyCard = new Card();
        luckyCard.setValue(12);
        luckyCard.setSuit("Hearts");

        int randomIndex = (int) (Math.random() * magicHand.length);
        magicHand[randomIndex] = luckyCard;

        System.out.println("You picked: " + userCard.getSuit() + ' ' + userCard.getValue());
        
        boolean found = false;
        for (Card card : magicHand) {
            if (userCard.getValue() == card.getValue() && userCard.getSuit().equalsIgnoreCase(card.getSuit())) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}
