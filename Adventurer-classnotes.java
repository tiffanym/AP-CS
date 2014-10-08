public class Adventurer-classnotes{

    private String name;

    private int HP,XP;

    \\ variables must be private   

    public Adventurer(){

        name=”Lester”;

        HP=20;

        XP=0;

}

public String getName(){

        return name;   

}   

public void setName(String name){

        this.name=name;  

    \\ since variables are private, accessors and mutators are required

    }

}
