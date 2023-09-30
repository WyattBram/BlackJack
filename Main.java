import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static Player player = new Player(500.);
    static Dealer dealer = new Dealer();
    Random rand = new Random();

    //populates the deck with 6 decks of cards
    //which is the amount used in most casinos
    public static ArrayList<Card> populate_deck(){
        ArrayList<Card> a = new ArrayList<>();
        String[] cards = {"2","3","4","5","6","7","8","9","10","K","Q","J","A"};
        int[] worth = {2,3,4,5,6,7,8,9,10,10,10,10,11};
        for (int i = 0; i<13; i++){
            for(int j = 0; j<24; j++){
                ///System.out.println(cards[i] + worth[i]);
                a.add(new Card(cards[i], worth[i]));
            }
        }
        return a;
    }

    public static void checkDeck(){
        if(deck.getCards().isEmpty()){
            populate_deck();
        }
    }

    public static void addToDealer(int i, Dealer d){

        for(int j = 0; j<i; j++){
            if (deck.getCards().size() < i){
                populate_deck();
            }
            Card c = deck.getCard();
            d.setCards_in_hand(c);
        }
    }

    public static void addToPlayer(int i, Player p){

        for(int j = 0; j<i; j++){
            if (deck.getCards().size() < i){
                populate_deck();
            }
            Card c = deck.getCard();
            p.setCard_in_hand(c);
        }
    }

    static Deck deck = new Deck(populate_deck());

    Scanner x = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;
        populate_deck();

        do{

            System.out.println(
                    "1. Play a hand\n" +
                            "2. Quit");

            Scanner x = new Scanner (System.in);
            choice = x.nextInt();
            x.nextLine();


            if (choice == 1){
                Boolean win = false;

                while (true){
                    Double bet = 0.;
                    if (player.getBalance() <= 0){
                        System.out.println("Your have lost!");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Your current balance is " + player.getBalance());
                        int gotBet = 0;
                        do{
                            System.out.println("How much would you like to bet");
                            bet = x.nextDouble();
                            x.nextLine();
                            if(bet > player.getBalance() || bet <= 0){
                                System.out.println("You don't have that much money");
                            }
                            else{
                                gotBet = 1;
                                player.setBalance(player.getBalance() - bet);
                            }

                        }while (gotBet == 0);
                    }
                    System.out.println("You bet " + bet + "\n" + "Your new balance is: " + player.getBalance());

                    addToDealer(2, dealer);
                    System.out.println("Dealers cards: " + dealer.toString());
                    addToPlayer(2, player);
                    System.out.println("Players cards: " + player.toString());

                    if(dealer.getValue(dealer.getCards_in_hand()) == 21
                            && player.getValue(player.getCards_in_hand()) == 21){
                        System.out.println("Its a draw!");
                        player.setBalance(player.getBalance() + bet);
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    if(dealer.getValue(dealer.getCards_in_hand()) == 21){
                        System.out.println("Dealer wins!");
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    if(player.getValue(player.getCards_in_hand()) == 21){
                        System.out.println("You win!");
                        player.setBalance(player.getBalance() + bet +(bet * 1.5));
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    /*else {
                        player.removeCards();
                        dealer.removeCards();
                        break;

                    }*/


                    while (true){
                        System.out.println("Would you like to hit or stand (Please type \"hit\" or \"stay\")");
                        String hitOrStay = x.nextLine();
                        if (Objects.equals(hitOrStay, "hit")){
                            addToPlayer(1, player);
                            System.out.println("Players cards: " + player.toString());
                            if(player.getValue(player.getCards_in_hand()) > 21 &&
                                player.getCards_in_hand().contains(){
                                System.out.println("You Busted!");
                                break;
                            }
                        }
                        else if(Objects.equals(hitOrStay, "stand")){
                            break;
                        }
                        else{
                            System.out.println("Please enter hit or stand");
                        }

                    }
                    if(player.getValue(player.getCards_in_hand()) > 21){
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    break;

                }








            }


        }while (choice != 2);



    }
}