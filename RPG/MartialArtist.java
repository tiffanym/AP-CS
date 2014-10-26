public class MartialArtist extends Adventurer{
    private int qui;
    
    public String getStats(){
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT "+getqui()+"qui";
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
	if (hit (other,hitchance) && getrage()-2>=0 && getHP()>0){
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
