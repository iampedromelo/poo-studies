package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private final String name;
    private int score;
    private Card[] cards;
    private int qtdCard;

    public Player(String name) {
        this.name = name;
        this.cards = new Card[3];
    }

    public void setCards(Card[] cards){
        this.cards = cards;
        qtdCard = 3;
    }

    public Card chooseCard(){
        if (qtdCard<=0) return null;
        int indexLastCard = --qtdCard;
        Card cardReturn = cards[indexLastCard];
        cards[indexLastCard] = null;

        return cardReturn;
    }

    public void incrementScore(){
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getStateAsString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("O jogador %s possui %d pontos e as seguintes cartas: ", this.name, this.score));
        for (int i = 0; i < qtdCard; i++) {
            builder.append(cards[i].toString()).append(" ");
        }
        return builder.toString();
    }
}
