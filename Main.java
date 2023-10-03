import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    //initiates the player and dealer
    static Player player = new Player(500.);
    static Dealer dealer = new Dealer();

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
    //need to use this function
    public static void checkDeck(){
        if(deck.getCards().isEmpty()){
            populate_deck();
        }
    }


    //  adds a certain amount of cards to dealers cards in hand
    public static void addToDealer(int i, Dealer d){

        for(int j = 0; j<i; j++){
            checkDeck();
            Card c = deck.getCard();
            d.setCard_in_hand(c);
        }
    }


    //  adds a certain amount of cards to players cards in hand
    public static void addToPlayer(int i, Player p){

        for(int j = 0; j<i; j++){
            checkDeck();
            Card c = deck.getCard();
            p.setCard_in_hand(c);
        }
    }


    //initiates a deck with the populate deck function
    static Deck deck = new Deck(populate_deck());

    //initiates scanner
    static Scanner x = new Scanner(System.in);



    public static void main(String[] args) throws InterruptedException {
        //Initiates choice for the while loop and populates the deck
        int choice;
        populate_deck();


        do{

            System.out.println(
                    "1. Play a hand\n" +
                            "2. Quit");


            choice = x.nextInt();
            x.nextLine();


            if (choice == 1){


                while (true){
                    //Gets the bet for the player and makes sure the player has the balance that they bet
                    Double bet = 0.;
                    if (player.getBalance() <= 0){
                        System.out.println("Your have lost!");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Your current balance is " + player.getBalance());
                        int gotBet = 0;
                        do{
                            System.out.println("How much would you like to bet:");
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

                    //Prints bet and displayes the players and dealers card(s)
                    System.out.println("You bet " + bet + "\n" + "Your new balance is: " + player.getBalance() +
                            "\n-------------------");

                    addToDealer(2, dealer);
                    System.out.println("Dealers cards: " + dealer.toStringFirst());
                    addToPlayer(2, player);
                    System.out.println("Players cards: " + player.toString());
                    System.out.println("-------------------");

                    //Checks for a double ace and changes one of the aces to 1
                    if(player.getValue() == 22){
                        player.changeAce(player.getCards_in_hand());
                    }
                    if(dealer.getValue() == 22){
                        dealer.changeAce(dealer.getCards_in_hand());
                    }

                    //Makes sure that the player, dealer, or both didn't get blackjack
                    if(dealer.getValue() == 21
                            && player.getValue() == 21){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("Its a draw!");
                        player.setBalance(player.getBalance() + bet);
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    if(dealer.getValue() == 21){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("Dealer wins!");
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    if(player.getValue() == 21){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("You win!");
                        player.setBalance(player.getBalance() + bet +(bet * 1.5));
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }


                    // Allows the player to stand or hit as much as they are able to
                    while (true){
                        System.out.println("Would you like to hit or stand (Please type \"hit\" or \"stand\")");
                        String hitOrStay = x.nextLine();
                        if (Objects.equals(hitOrStay, "hit")){
                            addToPlayer(1, player);
                            System.out.println("Players cards: " + player.toString());
                            if(player.getValue() > 21){
                                if(!player.changeAce(player.getCards_in_hand())){
                                    System.out.println("You Busted!");
                                    break;
                                }
                            }
                        }
                        else if(Objects.equals(hitOrStay, "stand")){
                            break;
                        }

                    }
                    //Makes sure the player didn't bust
                    if(player.getValue() > 21){
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }

                    //Prints the dealer and players cards and makes the dealer hit till they have <= 17
                    System.out.println("Dealers cards: " + dealer.toString());
                    System.out.println("----------------------");
                    TimeUnit.SECONDS.sleep(1);
                    while(true){
                        if (dealer.getValue() < 17){
                            addToDealer(1,dealer);
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("----------------------");
                            System.out.println("Dealers cards: " + dealer.toString());
                            System.out.println("----------------------");

                            if(dealer.getValue() > 21){
                                if(!dealer.changeAce(dealer.getCards_in_hand())){
                                    break;
                                }
                            }
                        }
                        else{
                            break;
                        }
                    }

                    //Checks to see who won the game
                    if(dealer.getValue() > 21){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("Dealer busted");
                        player.setBalance(player.getBalance() + (bet*2));
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }


                    if(dealer.getValue() == player.getValue()){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("Push!");
                        player.setBalance(player.getBalance() + bet);
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    if(dealer.getValue() > player.getValue()){
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("Dealer wins");
                        player.removeCards();
                        dealer.removeCards();
                        break;
                    }
                    else{
                        System.out.println("Dealers cards: " + dealer.toString());
                        System.out.println("Your cards: " + player.toString());
                        System.out.println("You win");
                        player.setBalance(player.getBalance() + (bet*2));
                        player.removeCards();
                        dealer.removeCards();
                    }
                    break;
                }
            }
        }while (choice != 2);
    }
}
