package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;


    public Round(String namePlayer1, Card card1, String namePlayer2, Card card2, Card vira){
        int vitoria = card1.compareValueTo(card2,vira);
        if(vitoria>0){winner = namePlayer1;}
        if(vitoria<0){winner = namePlayer2;}
    }

    public String getWinner() {
        return winner;
    }
}
