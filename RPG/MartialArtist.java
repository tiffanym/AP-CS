class MartialArtist extends Adventurer{
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

    public static void main(String[]args){
	Adventurer a;
	a=new MartialArtist();
	System.out.println(a.getStats());
    }
}
