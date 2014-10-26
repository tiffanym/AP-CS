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

    //attack method(s)    
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other,hitchance) && getqui()-2>=0 && getHP()>0){
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
	return msg+="=>Not enough qui or not high enough hit chance to use special attack \n"+
	    "==>"+getName()+" will attack normally instead: \n"+attack(other);
    }
}
