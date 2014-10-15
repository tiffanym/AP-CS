public class Adventurer{
    private String name;
    private int HP;

    //constructors
    public Adventurer(String name){
    	setName(name);
    }
    public Adventurer(){   
    }

    //setters and getters for variables    
    public String getName(){
	return name;
    }
    public void setName(String name){
	this.name=name;
    }

    public int getHP(){
	return HP;
    }
    public void setHP(int HP){
	this.HP=HP;
    }

    //attack method
    public String attack(Adventurer other){
	if (getName().equals(other.getName())){
	    return "I'm sorry, " +getName()+" but we don't promote self-mutilation in this game.";
	}
	return getName() + " attacks " + other.getName();
    }
}
