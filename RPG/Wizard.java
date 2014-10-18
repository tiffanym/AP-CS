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
	return super.getStats()+" "+getmana()+" mana";
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
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	if (hitMagic (other,hitchance) && getmana()-2>=0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.1)*getHP();
	    x=x+2;
	    return getName()+" switches staff for wand and uses mana power to critically burn "+other.getName()+" and does "+x+" damage";	  
	}
	return "Not enough mana or not high enough hit chance \n"+attack(other);
    }
}
