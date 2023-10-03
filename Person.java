import java.util.ArrayList;

//This class it meant to be extended for dealer and player and gives them some classes
public abstract class Person {

    protected ArrayList<Card> cards_in_hand;


    //Changes the value of an ace from 11 to 1 if needed
    public Boolean changeAce(ArrayList<Card> c){
        for(int i = 0; i< cards_in_hand.size(); i++){
            if(c.get(i).getValue() == 11) {
                c.get(i).setValue(1);
                return true;
            }

        }
        return false;
    }


    //Returnes the values of the cards in a persons hand
    public int getValue(){
        int total = 0;
        for (Card card : cards_in_hand) {
            total += card.getValue();
        }
        return total;
    }

    //Simple getters and setters
    public void setCard_in_hand(Card c) {
        this.cards_in_hand.add(c);
    }

    public ArrayList<Card> getCards_in_hand() {
        return cards_in_hand;
    }



    //Removes cards in a hand: Used when a game is won by someone
    public void removeCards(){
        cards_in_hand.clear();
    }


    // Prints out the cards in hand for the player
    @Override
    public String toString(){
        String cont = "";
        for (Card card : cards_in_hand) {
            cont += card.getFace() + " ";
        }
        return cont;
    }
}
