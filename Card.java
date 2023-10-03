public class Card {
    //face is what is shown on the card
    private final String face;
    //value is the amount that card is worth
    private int value;

    //Makes cards that will later be put in arraylist
    Card(String f, int v){
        this.face = f;
        this.value = v;
    }


    //simple getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getFace() {
        return face;
    }
}
