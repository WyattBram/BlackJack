import java.util.ArrayList;

public abstract class Person {

    protected ArrayList<Card> cards_in_hand;

    public Boolean changeAce(ArrayList<Card> c){
        for(int i = 0; i< cards_in_hand.size(); i++){
            if(c.get(i).getValue() == 11) {
                c.get(i).setValue(1);
                return true;
            }

        }
        return false;
    }
    public void setCard_in_hand(Card c) {
        this.cards_in_hand.add(c);
    }

    public ArrayList<Card> getCards_in_hand() {
        return cards_in_hand;
    }
    public void removeCards(){
        cards_in_hand.clear();
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
