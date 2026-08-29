package br.edu.ifsp;

import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Player;

public class Principal {
    public static void main(String[] args) {
        Player player1 = new Player("Pedro");
        Player player2 = new Player("Pato");

        Game game = new Game(player1,player2);
        while(!game.isDone()) {
            if(!game.getHand().isDone()) {
                System.out.println("A vira é: " + game.getViraHand());
                System.out.println(player1.getStateAsString());
                System.out.println(player2.getStateAsString());
            }
            game.play();
        }
        System.out.println("O vencedor do jogo é: " + game.getWinner().getName());
    }
}
