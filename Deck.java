import java.util.ArrayList;
import java.util.Random;

public class Deck {
    Random rand = new Random();
    private ArrayList<Card> cards;

    //Constructs a deck
    Deck(ArrayList<Card> c){
        cards = c;
    }

    //Gets cards in deck
    public ArrayList<Card> getCards() {
        return cards;
    }

    //Used to get a card to add to a player or dealers hand and deletes it from the deck
    public Card getCard() {
        int removed_card_index = rand.nextInt(0,cards.size());
        Card a = cards.get(removed_card_index);
        cards.remove(removed_card_index);
        return a;
    }
}
