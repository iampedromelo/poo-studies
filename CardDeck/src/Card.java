public class Card {
    private final Suit suit;
    private final Rank rank;
    private boolean folded;

    public Card(Suit suit, Rank rank, boolean folded){
        this.suit = suit;
        this.rank = rank;
        this.folded = folded;
    }

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
        folded = true;
    }

    public String cardAsString(){
        return folded? "XX" : rank +" "+suit;
    }

    public void faceUp(){
        folded = false;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public boolean isFolded(){
        return folded;
    }






}
