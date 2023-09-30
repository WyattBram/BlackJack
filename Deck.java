import java.util.ArrayList;
import java.util.Random;

public class Deck {
    Random rand = new Random();
    private ArrayList<Card> cards;

    Deck(ArrayList<Card> c){
        cards = c;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard() {
        int removed_card_index = rand.nextInt(0,cards.size());
        Card a = cards.get(removed_card_index);
        cards.remove(removed_card_index);
        return a;
    }
}
