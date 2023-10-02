import java.util.ArrayList;

public class Player extends Person {
    private Double balance;

    //creates a player and gives them a balance and cards in hand
    Player(Double balance){
        this.balance = balance;
        cards_in_hand = new ArrayList<Card>();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getValue(ArrayList<Card> c){
        int total = 0;
        for(int i = 0; i< cards_in_hand.size(); i++){
            total += cards_in_hand.get(i).getValue();
        }
        return total;
    }
}
