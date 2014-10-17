public class Rogue extends Adventurer{
    private int stamina;
    
    //constructors
    public Rogue (String name){
	super(name);
	setSTA((int)(Math.random()*20)+1);
	setSTR((int)(Math.random()*21)+10);
	setDEX((int)(Math.random()*51)+10);
	setINT((int)(Math.random()*41)+10);
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

    //toString method
    public String toString(){
	return super.toString()+" "+getSTA()+" stamina";
    }

    //attack method(s)
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	if (hit (other,hitchance) && getSTA()-2>=0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.3)*getHP();
	    x=x+5;
	    setSTA(getSTA()-2);
	    return getName()+" stealthily hides in the trees and throws shurikens at "+other.getName()
		+" and does "+x+" damage";
	}
	return "Not enough stamina or not high enought hit chance \n"+attack(other);
    }
}
