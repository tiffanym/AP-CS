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
    }

    //get and set methods for variables
    public int getrage(){
	return rage;
    }

    public void setrage(int rage){
	this.rage=rage;
    }
   
    //toString method
    public String toString(){
	return super.toString()+" "+getrage()+" rage";
    }

    //attack method(s)    
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	if (hit (other,hitchance) && getrage()-2>=0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.5)*getHP();
	    x=x+10;
	    setrage(getrage()-2);
	    return getName()+" uses full rage and critically strikes "+
		other.getName()+" and does "+x+" damage";
	}
	return "Not enough rage or not high enough hit chance \n"+attack(other);
    }
}   
