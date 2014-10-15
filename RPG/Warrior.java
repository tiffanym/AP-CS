public class Warrior extends Adventurer{
    private int rage;
    
    //constuctors
    public Warrior(String s){
	super(s);
    }
    public Warrior(){
	super();
    }

    //get and set methods for variables
    public int getrage(){
	return rage;
    }

    public void setrage(int rage){
	this.rage=rage;
    }
    
    //attack method(s)
    public String specialAttack(Adventurer other){
	return getName()+" uses full rage and critically strikes "+other.getName();
    }
}   
