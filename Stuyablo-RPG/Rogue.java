public class Rogue extends Adventurer{
    private int stamina;
    
    //constructors
    public Rogue (String name){
	super(name);
	maxHP=this.getHP();
	setSTA((int)(Math.random()*20)+1);
	maxResource=this.getSTA();
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
	return getName()+"["+getClass().getSimpleName()+"]"+getHP()+" HP "+getSTR()+" STR "+getDEX()+" DEX "+getINT()+" INT "+getSTA()+" stamina";
    }

    //attack method(s)
    public String attack(Adventurer other){
	String msg=getName()+" the "+getClass().getSimpleName()+" attacks "+other.getName()+" the "+other.getClass().getSimpleName()+"\n";
	if (hit(other) && getHP()>0 && other.getHP()>0){
	    int x=(int)(this.getDEX()*2/3);
	    x=Math.abs(x);
	    if (other.getHP()-x>0 && x>0){	       
		other.setHP(other.getHP()-x);
		msg=msg+"=>Yay! "+getName()+" successfully hit "+
		    other.getName()+" and did "+ x+ " damage";
	    }
	    else if (other.getHP()-x<=0 && x>0){
		other.setHP(0);
		msg=msg+"=>Dayum! "+getName()+" did " +x+
		    " damage and KOed "+other.getName();
	    }
	}
	else if (getHP()<=0){
	    msg+="=>Not enough HP. Sorry,"+getName()+" can't attack when you're dead";
	}	
	else if(other.getHP()<=0){
	    return msg+="=>Well, um... "+ other.getName()+"is kinda... sorta... dead. x.x";
	}
	else{
	    msg= msg+"=>...and misses :(";
	    int x=(int)(this.getSTR()*2/3);
	}
	return msg;
    }

    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other) && getSTA()-2>=0 && getHP()>0 && other.getHP()>0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.3)*getDEX();
	    x=Math.abs(x)+5;
	    setSTA(getSTA()-2);
	    other.setHP(other.getHP()-x);
	    if (other.getHP()<=0){
		other.setHP(0);
	    }
	    return msg+="=>"+getName()+" stealthily hides in the trees and throws shurikens at "+other.getName()
		+" and does "+x+" damage";
	}
	else if(getHP()<=0){
	    return msg+="=>Not enough HP. Sorry, "+getName()+", can't attack when you're dead";
	}
	else if(other.getHP()<=0){
	    return msg+="=>Well, um... "+ other.getName()+"is kinda... sorta... dead. x.x";
	}
	return msg+="=>Not enough stamina or not high enought hit chance to use special attack \n"+"==>"+getName()+" will attack normally instead: \n"+attack(other);
    }

    public Rogue clone(){
	Rogue ans;
	ans=new Rogue(name);
	ans.setHP(HP);
	ans.setSTR(STR);
	ans.setDEX(DEX);
	ans.setINT(INT);
	ans.setSTA(stamina);
	return ans;
    }
    
    public void healAll(){
	setHP(maxHP);
	setSTA(maxResource);
    }
}
