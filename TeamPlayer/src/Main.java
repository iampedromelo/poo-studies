public static void main(String[] args){

    Player player1 = new Player("Pedro", 10, "Meio-Campo", true );
    Player player2 = new Player("Pedro", 10, "Meio-Campo", true );
    Player player3 = new Player("Pedro Melo", 11, "Atacante", false );

    Team time = new Team("Palmeiras","Votuporanga", "João Melo");
    time.addPlayer(player1);
    time.addPlayer(player2);
    time.addPlayer(player3);

    for(int i=0; i<time.getFieldedPlayers().length;i++){
        System.out.println(time.getFieldedPlayers()[i].getName());
    }
    for(int i=0; i<time.getOutfieldedPlayers().length;i++){

        System.out.println(time.getOutfieldedPlayers()[i].getName());
    }

    time.setCaptain(player3);
    System.out.println(time.getCaptain().getName());
}