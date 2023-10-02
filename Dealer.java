import java.util.ArrayList;


public class Dealer extends Person{

    //creats a dealer and gives them cards in hand
    Dealer(){
        this.cards_in_hand = new ArrayList<Card>();
    }

    public int getValue(ArrayList<Card> c){
        int total = 0;
        for(int i = 0; i< cards_in_hand.size(); i++){
            total += cards_in_hand.get(i).getValue();
        }
        return total;
    }


    public String toStringFirst(){
        return cards_in_hand.get(0).getFace() + " ?";
    }
}
