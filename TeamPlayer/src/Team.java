public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] players;
    private int totalPlayers;
    private Player captain;

    //primeiro o construtor sem players e capitão
    public Team(String name, String baseLocation, String coachName){
        this.name = name;
        setBaseLocation(baseLocation);
        setCoachName(coachName);
        players = new Player[18];
        totalPlayers = 0;
    }
    private int isPlayerInTeam(Player player){
        for(int i=0;i<totalPlayers;i++){
            if((player.getName()).equals(players[i].getName())) return i; //dá pra inserir mais parametros de comparação
        }
        return -1;
    }
    private boolean isFull(){
        return totalPlayers == 18;
    }

    public void addPlayer(Player player){
        if((isPlayerInTeam(player) != -1) || isFull()) return;
        players[totalPlayers++] = player;
    }

    public void removePlayer(Player player){
        int indexPlayer = isPlayerInTeam(player);
        if(indexPlayer != -1){
            for(int i=indexPlayer;i<totalPlayers-1;i++){
                players[i]=players[i+1];
            }
            players[--totalPlayers] = null;
        }
        return;
    }

    public void substitute(Player substitute, Player starter){
        int indexPlayer = isPlayerInTeam(starter);
        if(indexPlayer != -1){
            players[indexPlayer] = substitute;
        }
        return;
    }

    public void setCaptain(Player captain){
        if(isPlayerInTeam(captain) == -1) return;
        this.captain = captain;
    }

    public Player[] getFieldedPlayers(){
        //nao tem muito o que fazer, preciso contar quantos fielded são primeiro pra criar o array depois
        int numberFilded = 0;
        for(int i=0; i < totalPlayers;i++){
            if(players[i].getIsFielded()) numberFilded++;
        }
        if (numberFilded == 0) return null;
        Player[] fieldedPlayers = new Player[numberFilded];
        numberFilded = 0;
        for(int i=0; i < totalPlayers;i++){
            if(players[i].getIsFielded()) {
                fieldedPlayers[numberFilded++] = players[i];
            };
        }
        return  fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers(){
        //nao tem muito o que fazer, preciso contar quantos outfielded são primeiro pra criar o array depois
        int numberOutfilded = 0;
        for(int i=0; i < totalPlayers;i++){
            if(!players[i].getIsFielded()) numberOutfilded++;
        }
        if (numberOutfilded == 0) return null;
        Player[] outfieldedPlayers = new Player[numberOutfilded];
        numberOutfilded = 0;
        for(int i=0; i < totalPlayers;i++){
            if(!players[i].getIsFielded()) {
                outfieldedPlayers[numberOutfilded++] = players[i];
            };
        }
        return  outfieldedPlayers;
    }

    public void setBaseLocation(String baseLocation){
        this.baseLocation = baseLocation;
    }


    public void setCoachName(String coachName){
        this.coachName = coachName;
    }


    public Player getCaptain(){
        return  captain;
    }

}
