public class Warrior extends Adventurer{
    private int bonusHealth;
    
    public Warrior(){
	super();
    }
    

    public int getHP(){
	return super.getHP()+bonusHealth;
    } 
}
