abstract class Adventurer{
    protected String name;
    protected int HP;
    protected int STR;
    protected int DEX;
    protected int INT;
    protected int maxHP;
    protected int maxResource;


    //constructors
    public Adventurer(String name,int HP, int STR, int DEX, int INT){
    	setName(name);
	setHP(HP);
	setSTR(STR);	  
	setDEX(DEX);
	setINT(INT);
    }

    //int num = (int) (Math.random()*range)+min
    //where "range=(max-min)+1"
    public Adventurer (String name){
	this(name, (int)(Math.random()*81)+20, 
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10);
    }
    public Adventurer(){   
	this("Bob", (int)(Math.random()*81)+20, 
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10);
    }

    //setters and getters for variables    
    public String getName(){
	return name;
    }
    public void setName(String name){
	this.name=name;
    }

    public int getHP(){
	return HP;
    }
    public void setHP(int HP){
	this.HP=HP;
    }

    public int getSTR(){
	return STR;
    }
    public void setSTR(int STR){
	this.STR=STR;
    }

    public int getDEX(){
	return DEX;
    }
    public void setDEX(int DEX){
	this.DEX=DEX;
    }

    public int getINT(){
	return INT;
    }
    public void setINT(int INT){
	this.INT=INT;
    }

    //toString method
    abstract String getStats();
    /*{
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT ";
    }
    */

    //for special attack
    public int getMaxStatDiff(){
	int STRINT= Math.abs(getSTR()-getINT());
	int DEXINT= Math.abs(getDEX()-getINT());
	int STRDEX= Math.abs(getSTR()-getDEX());
	int maxspan=STRINT;
	if (DEXINT>=maxspan){
	    maxspan=DEXINT;
	}
	else if(STRDEX>=maxspan){
	    maxspan=STRDEX;
	}
	return maxspan;
    }

    //hit method
    public boolean hit (Adventurer other){
	int randSTR=(int)(Math.random()*25)+1;
	int randDEX=(int)(Math.random()*25)+1;
	int randINT=(int)(Math.random()*25)+1;
	int randTotal=(int)(Math.random()*71)+30;
	int x=randSTR+randDEX+randINT;
	if (x<randTotal){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    //attack method
    abstract String attack(Adventurer other);
    /*{
	String msg=getName()+" the "+getClass().getSimpleName()+" attacks "+other.getName()+" the "+other.getClass().getSimpleName()+"\n";
	if (hit(other) && getHP()>0 && other.getHP()>0){
	    //int x=(int)(this.getDEX()/other.getDEX());
	    int x=(int)(this.getMaxStatDiff()*2/3);
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
	}
	return msg;
    }
    */
    
    abstract String specialAttack(Adventurer other);
    /*{
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other) && getHP()>11 && other.getHP()>0){
	    int x=(int)((1.00-(double)(this.getMaxStatDiff()/other.getMaxStatDiff()))*getHP());
	    x=Math.abs(x)+3;
	    setHP(getHP()-10);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" uses <some special attack an Adventurer would have> and strikes "+
		other.getName()+" and does "+x+" damage";
	}
	else if(getHP()<=11){
	    return msg+="=>Not enough HP to use special attack. Try again, "+getName()+".";
	}
	else if(getHP()==0){
	    return msg+="=>Sorry,"+getName()+", can't attack when you're dead";
	}
	else if(other.getHP()<=0){
	    return msg+="=>Well, um... "+ other.getName()+"is kinda... sorta... dead. x.x";
	}
	//else{
	//   return msg+="Cruel Gods of Java, WHY ISN'T THIS WORKING?!?!?!?!";
	//}
	return msg+="=>Not high enought hit chance \n"+"==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
    */

    public abstract Adventurer clone();
    
    protected abstract void healAll();
}
