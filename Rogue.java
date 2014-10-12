public class Rogue extends Adventurer{
    private int stamina;
    
    //constructors
    public Rogue (String name){
	super(name);
    }
    public Rogue(){
	super();
    }

    //get and set methods for variables
    public int getSTA(){
	return stamina;
    }
    public void setSTA(int stamina){
	this.stamina=stamina;
    }

    //attack method(s)
    public String specialAttack(Adventurer other){
	return getName()+" stealthily hides in the trees and throws shurikens at "+other.getName();
    }
    
}
