import java.util.ArrayList;

public class Player extends Person {
    private Double balance;

    //creates a player and gives them a balance and cards in hand
    Player(Double balance){
        this.balance = balance;
        cards_in_hand = new ArrayList<Card>();
    }


    //Simple getters and setters
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
