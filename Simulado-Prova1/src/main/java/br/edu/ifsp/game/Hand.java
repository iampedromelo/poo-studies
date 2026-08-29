package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private final Player player1;
    private final Player player2;
    private final Round[] rounds;
    private int qtdRounds;
    private final Card vira;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = new Round[3];
        Deck deck = new Deck();
        deck.shuffle();
        vira = deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
    }

    public void playRound(){
        Round round = new Round(player1.getName(),player1.chooseCard(),player2.getName(),player2.chooseCard(),vira);

        String winner = round.getWinner();

        System.out.println((winner == null)? "Não há vencedor! \n" : String.format("O vencedor é: %s \n",winner));
        rounds[qtdRounds++] = round;
    }

    public boolean isDone(){
        if (qtdRounds <= 1) return false;
        if(qtdRounds == 2){
            if((rounds[0].getWinner() == null) && (rounds[1].getWinner() == null)) return false;
            if((rounds[0].getWinner() == null) ^ (rounds[1].getWinner() == null)) return true;
            return rounds[0].getWinner().equals(rounds[1].getWinner());
        }
        return true;
    }

    public String getWinner(){
        if (!isDone()) return null;
        if (qtdRounds == 2){
            if(rounds[0].getWinner() == null) {
                return rounds[1].getWinner();
            }else{
                return rounds[0].getWinner();
            }
        }
        if (qtdRounds >= 3){
            if((rounds[0].getWinner() == null) && (rounds[1].getWinner() == null) && (rounds[2].getWinner() == null)) return null;
            if((rounds[0].getWinner() == null) && (rounds[1].getWinner() == null)) return rounds[2].getWinner();
            if((rounds[2].getWinner() == null)) return rounds[0].getWinner();
            return rounds[2].getWinner();
        }
        return null;
    }

//    public String getStateAsString(){
//        StringBuilder builder = new StringBuilder();
//        builder.append("A mão possui os seguintes vencedores de cada rodada: ");
//        for (int i = 0; i <qtdRounds; i++) {
//            builder.append(String.format("%d - %s"));
//
////        }
//    }


    public Card getVira() {
        return vira;
    }
}
