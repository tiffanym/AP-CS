public class Driver{
    public static void main(String[]args){
	Adventurer a= new Adventurer("Bob");
	Warrior b = new Warrior("Dan");
	Wizard c= new Wizard("Merlin");
	Rogue d= new Rogue("Al");

	System.out.println(a.getStats());
	System.out.println(b.getStats());
	System.out.println(c.getStats());
	System.out.println(d.getStats());
	System.out.println();

	System.out.println(a.attack(b));
	System.out.println();

	System.out.println(b.attack(c));
	System.out.println(b.specialAttack(a));
	System.out.println();

	System.out.println(c.attack(d));
	System.out.println(c.specialAttack(b));
	System.out.println();

	System.out.println(d.attack(a));
	System.out.println(d.specialAttack(c));
	System.out.println();

	System.out.println(a.getStats());
	System.out.println(b.getStats());
	System.out.println(c.getStats());
	System.out.println(d.getStats());
    }
}
