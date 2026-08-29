public class Player {
    private String name;
    private int number;
    private String position; //could be an enum
    private boolean isFielded;

    public Player(String name, int number, String position, boolean isFielded){
        this.name = name;
        setNumber(number);
        setPosition(position);
        setIsFielded(isFielded);

    }

    public String getStateAsString(){
        return String.format(
                """
                Name: %s,
                Number: %d
                Position: %s,
                Fielded: %b""",name,number,position,isFielded
        );
    }

    public String getName(){
        return name;
    }

    public void setNumber(int number){
        this.number =  number;
    }

    public int getNumber(){
        return number;
    }

    public void setPosition(String position){
        this.position =  position;
    }

    public String getPosition(){
        return position;
    }

    public void setIsFielded(boolean isFielded){
        this.isFielded =  isFielded;
    }

    public boolean getIsFielded(){
        return isFielded;
    }

}
