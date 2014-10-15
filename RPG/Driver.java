public class Driver{
    public static void main(String[]args){
	Adventurer a= new Adventurer("Bob");
	Warrior b = new Warrior("Dan");
	Wizard c= new Wizard("Merlin");
	Rogue d= new Rogue("Al");
	/*
	System.out.println(a.attack(b));
	System.out.println(b.attack(a));
	System.out.println(c.attack(a));
	System.out.println(d.attack(a));
	System.out.println("What happens if Bob attacks himself?" +
			   a.attack(a));
	
	System.out.println(b.specialAttack(a));
	System.out.println(c.specialAttack(a));
	System.out.println(d.specialAttack(a));
	*/
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(a.hit(b,.7));
	System.out.println(b.hit(a,.5));
	System.out.println(a.attack(b));
	System.out.println(b.attack(a));
    }
}
