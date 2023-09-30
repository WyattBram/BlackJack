import java.util.ArrayList;
public class Dealer {
    private ArrayList<Card> cards_in_hand;

    //creats a dealer and gives them cards in hand
    Dealer(){
        this.cards_in_hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards_in_hand() {
        return cards_in_hand;
    }
    public void removeCards(){
        cards_in_hand.clear();
    }

    public void setCard_in_hand(ArrayList<Card> cards_in_hand) {
        this.cards_in_hand = cards_in_hand;
    }

    public void setCards_in_hand(Card c) {
        this.cards_in_hand.add(c);
    }

    public int getValue(ArrayList<Card> c){
        int total = 0;
        for(int i = 0; i< cards_in_hand.size(); i++){
            total += cards_in_hand.get(i).getValue();
        }
        return total;
    }

    @Override
    public String toString(){
        String cont = "";
        for (int i = 0; i<cards_in_hand.size();i++){
            cont += cards_in_hand.get(i).getFace() + " ";
        }
        return cont;
    }
}
