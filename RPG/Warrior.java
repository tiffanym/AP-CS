public class Warrior extends Adventurer{
    private int rage;
    
    //constuctors
    public Warrior(String s){
	super(s);
	setrage((int)(Math.random()*15)+1);
	setSTR((int)(Math.random()*51)+10);
	setDEX((int)(Math.random()*41)+10);
	setINT((int)(Math.random()*21)+10);
    }
    public Warrior(){
	super();
	setrage((int)(Math.random()*15)+1);
    }

    //get and set methods for variables
    public int getrage(){
	return rage;
    }

    public void setrage(int rage){
	this.rage=rage;
    }
   
    //toString method
    public String getStats(){
	return super.getStats()+" "+getrage()+" rage";
    }

    //attack method(s)    
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other,hitchance) && getrage()-2>=0 && getHP()>0){
	    int x=(int)((1.00- (double)(getSTR()/other.getSTR()))*1.5)*getSTR();
	    x=Math.abs(x)+10;
	    setrage(getrage()-2);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" uses full rage and critically strikes "+
		other.getName()+" and does "+x+" damage";
	}
	else if(getHP()<=0){
	    return msg+="=>Not enough HP. Sorry, "+getName()+", can't attack when you're dead";
	}
	return msg+="=>Not enough rage or not high enough hit chance to use special attack \n"+
	    "==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
}   
