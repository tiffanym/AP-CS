public class Wizard extends Adventurer{
    private int mana;
    
    //constructors
    public Wizard(String name){
	super(name);
	setmana((int)(Math.random()*10)+1);
	setSTR((int)(Math.random()*41)+10);
	setDEX((int)(Math.random()*21)+10);
	setINT((int)(Math.random()*51)+10);
    }
    public Wizard(){
	super();
	setmana((int)(Math.random()*10)+1);
    }
    
    //get and set methods for variables
    public int getmana(){
	return mana;
    }
    public void setmana(int mana){
	this.mana=mana;
    }

    //toString method
    public String getStats(){
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT "+getmana()+" mana";
    }
   
    //hitMagic() method for wizard to calculate hit%
    public boolean hitMagic(Adventurer other, double hitchance){
	double actualhitrate=this.getINT()/other.getINT();
	if (actualhitrate<=hitchance && Math.abs(actualhitrate)<=1){
	    return true;
	}
	else{
	    return false;
	}
    }

    //attack method(s)
public String attack(Adventurer other){
	String msg=getName()+" the "+getClass().getSimpleName()+" attacks "+other.getName()+" the "+other.getClass().getSimpleName()+"\n";
	if (hit(other) && getHP()>0){
	    int x=(int)(this.getINT()/other.getINT());
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
	else{
	    msg= msg+"=>...and misses :(";
	    int x=(int)(this.getINT()/other.getINT());
	}
	return msg;
    }

    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hitMagic (other,hitchance) && getmana()-2>=0 && getHP()>0){
	    int x=(int)((1.00- (double)(getINT()/other.getINT()))*1.1)*getINT();
	    x=Math.abs(x)+2;
	    setmana(getmana()-2);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" switches staff for wand and uses mana power to critically burn "+other.getName()+" and does "+x+" damage";
	}
	else if(getHP()<=0){
	    return msg+="=>Not enough HP. Sorry, "+getName()+", can't attack when you're dead";
	}
	return msg+="=>Not enough mana or not high enough hit chance to use special attack \n"+"==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
}
