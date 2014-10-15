public class Adventurer{
    private String name;
    private int HP;
    private int DEX;

    //constructors
    public Adventurer(String name,int HP, int DEX){
    	setName(name);
	setHP(HP);
	setDEX(DEX);
    }
    //int num = (int) (Math.random()*range)+min
    //where "range=(max-min)+1"
    public Adventurer (String name){
	this(name, (int)(Math.random()*81)+20, 
	     (int)(Math.random()*41)+10);
    }
    public Adventurer(){   
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

    public int getDEX(){
	return DEX;
    }
    public void setDEX(int DEX){
	this.DEX=DEX;
    }

    //toString method
    public String toString(){
	return "Name: "+getName()+"\n HP: "+getHP()+"\n Dex: "+DEX;
    }

    //hit method-- will you hit the person or not
    //QUESTION: Why is actualhitrate<= hitchance the only way it works?
    public boolean hit(Adventurer other, double hitchance){
	double actualhitrate=this.getDEX()/other.getDEX();
	if (actualhitrate<=hitchance && Math.abs(actualhitrate)<=1){
	    return true;
	}
	else{
	    return false;
	}
    }

    //attack method
    public String attack(Adventurer other){
	/*
	if (getName().equals(other.getName())){
	    return "I'm sorry, " +getName()+" but we don't promote self-mutilation in this game.";
	}
	return getName() + " attacks " + other.getName();
	*/
	String msg="Did you, "+getName()+", successfully attack "+other.getName()+"? \n";
	double hitchance= (double)(Math.random()*2)+0;
	if (hit(other, hitchance)){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*getHP());
	    if (x==0){
		x=5;
	    }
	    if (other.getHP()-x>0){
		other.setHP(other.getHP()-x);
		msg=msg+"Yay! "+getName()+" successfully hit "+
		    other.getName()+" and did "+ x+ " damage";
	    }
	    else if (other.getHP()-x<=0){
		other.setHP(0);
		msg=msg+"Dayum! "+getName()+" did " +x+
		    " damage and KOed "+other.getName();
	    }
	}
	else{
	    msg= msg+"Sorry "+getName()+", but "+other.getName()+" was a lot faster than you and dodged your hit. That's life.";
	}
	return msg;
    }
}
