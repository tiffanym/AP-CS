public class MartialArtist extends Adventurer{
    private int qui;
    
    //constuctors
    public MartialArtist(String s){
	super(s);
	setqui((int)(Math.random()*15)+1);
	setSTR((int)(Math.random()*31)+10);
	setDEX((int)(Math.random()*31)+10);
	setINT((int)(Math.random()*31)+10);
    }
    public MartialArtist(){
	super();
	setqui((int)(Math.random()*15)+1);
    }
    
    public int getqui(){
	return qui;
    }
    public void setqui(int qui){
	this.qui=qui;
    }
    
    public String getStats(){
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT "+getqui()+" qui";
    }

    //because Martial Artist is just that awesome
    public int highestStat(){
	int highest=getSTR();
	if (getDEX()>highest){
	    highest=getDEX();
	}
	else if (getINT()>highest){
	    highest=getINT();
	}
	return highest;	
    }

    //attack method(s)    
    public String attack(Adventurer other){
	String msg=getName()+" the "+getClass().getSimpleName()+" attacks "+other.getName()+" the "+other.getClass().getSimpleName()+"\n";
	if (hit(other) && getHP()>0 && other.getHP()>0){
	    int x=(int)(this.highestStat()*2/3);
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
	if (hit (other) && getqui()-2>=0 && getHP()>0 && other.getHP()>0){
	    int x=(int)((1.00- (double)(getDEX()/other.getDEX()))*1.5)*getDEX();
	    x=Math.abs(x)+12;
	    setqui(getqui()-2);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" calls upon the Almighty Powers of Qui to critically strike "+
		other.getName()+" and does "+x+" damage";
	}
	else if(getHP()<=0){
	    return msg+="=>Not enough HP. Sorry, "+getName()+", can't attack when you're dead";
	}
	else if(other.getHP()<=0){
	    return msg+="=>Well, um... "+ other.getName()+"is kinda... sorta... dead. x.x";
	}
	return msg+="=>Not enough qui or not high enough hit chance to use special attack \n"+
	    "==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
}
