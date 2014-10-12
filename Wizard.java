public class Wizard extends Adventurer{
    private int mana;
    
    //constructors
    public Wizard(String name){
	super(name);
    }
    public Wizard(){
	super();
    }
    
    //get and set methods for variables
    public int getmana(){
	return mana;
    }
    public void setmana(int mana){
	this.mana=mana;
    }
    
    //attack method(s)
    public String specialAttack(Adventurer other){
	return getName()+" switches staff for wand and uses mana power to critically burn "+other.getName();
    }
}
