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
	setSTA((int)(Math.random()*20)+1);
    }

    //get and set methods for variables
    public int getSTA(){
	return stamina;
    }
    public void setSTA(int stamina){
	this.stamina=stamina;
    }

    //toString method
    public String getStats(){
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT "+getSTA()+" stamina";
    }

    //attack method(s)
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other,hitchance) && getSTA()-2>=0 && getHP()>0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.3)*getDEX();
	    x=Math.abs(x)+5;
	    setSTA(getSTA()-2);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" stealthily hides in the trees and throws shurikens at "+other.getName()
		+" and does "+x+" damage";
	}
	else if(getHP()<=0){
	    return msg+="=>Not enough HP. Sorry, "+getName()+", can't attack when you're dead";
	}
	return msg+="=>Not enough stamina or not high enought hit chance to use special attack \n"+"==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
}
