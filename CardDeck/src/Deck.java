public class Deck {
    private Card[] deck = new Card[40];
    private int amountCards = 0;

    public Deck(){
        for(Suit suit : Suit.values() ){
            for(Rank rank : Rank.values()){
                deck[amountCards++] = new Card(suit, rank);
            }
        }
    }

    private boolean canTake(){
        return amountCards > 0;
    }

    public Card takeOne(){
        if (!canTake()) return null;
        Card card = deck[amountCards-1];
        deck[--amountCards] = null;
        return card;
    }

    public Card[] takeMany(int number){
        Card[] cards = new Card[number];
        for(int i=0; i<number; i++){
            cards[i] = takeOne();
        }
        return cards;
    }

}
