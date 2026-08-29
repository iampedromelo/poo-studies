package br.edu.ifsp.game;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Hand[] hands;
    private int qtdHands;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        hands = new Hand[30];
        hands[qtdHands++] = new Hand(this.player1,this.player2);

    }

    public void play(){
        if(hands[qtdHands-1].isDone()){
            String winnerPlayer = hands[qtdHands-1].getWinner();
            System.out.println("O winner dentro da play é: " + winnerPlayer);
            if ((player1.getName()).equals(winnerPlayer)){
                player1.incrementScore();
                System.out.println("O vencedor da mão foi: " + winnerPlayer + "\n");
            } else if ((player2.getName()).equals(winnerPlayer)) {
                player2.incrementScore();
                System.out.println("O vencedor da mão foi: " + winnerPlayer + "\n");
            } else{
                System.out.println("A mão terminou empatada!");
            }
            System.out.println("------- Próxima mão! ------- \n");
            hands[qtdHands++] = new Hand(this.player1,this.player2);
        }else{
            hands[qtdHands-1].playRound();
        }

    }

    public boolean isDone(){
        return player1.getScore() == 12 || player2.getScore() == 12;
    }

    public Player getWinner(){
        if (!isDone()) return null;
        return player1.getScore() > player2.getScore()? player1 : player2;
    }

    public String getViraHand() {
        return hands[qtdHands-1].getVira().toString();
    }
    public Hand getHand() {
        return hands[qtdHands-1];
    }
}
