
public static void main(String[] args) {
    final Deck deck = new Deck();
    var oneCard = deck.takeOne();
    System.out.println(oneCard != null? oneCard.cardAsString(): "");

    Card[] manyCards = deck.takeMany(41);
    for (Card card : manyCards) {
        if(card!=null) {
            card.faceUp();
            System.out.println(card.cardAsString());
        }}

}