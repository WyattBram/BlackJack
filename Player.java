import java.util.ArrayList;

public class Player {
    private Double balance;
    private ArrayList<Card> cards_in_hand;

    //creates a player and gives them a balance and cards in hand
    Player(Double balance){
        this.balance = balance;
        cards_in_hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards_in_hand() {
        return cards_in_hand;
    }

    public void removeCards(){
        cards_in_hand.clear();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCard_in_hand(Card c) {
        this.cards_in_hand.add(c);
    }

    public Boolean changeAce(ArrayList<Card> c){
        for(int i = 0; i< cards_in_hand.size(); i++){
            if(c.get(i).getValue() == 11) {
                c.get(i).setValue(1);
                return true;
            }

        }
        return false;
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
