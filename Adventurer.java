public class Adventurer{
    private String name;
    private int HP;
    
    public Adventurer(String name){
    	setName(name);
    }
    
    public Adventurer(){   
    }
    
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
}
