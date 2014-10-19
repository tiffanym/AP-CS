public class Driver{
    public static void main(String[]args){
	Adventurer p1 =new Adventurer("Chadwick");
	Warrior p2 =new Warrior("Grobnar");
	Wizard p3 = new Wizard("Merlin");
	Rogue p4 = new Rogue("Inigo Montoya");
	
	System.out.println(p1.getStats());
	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();
	
	System.out.println(p1.attack(p2));
	System.out.println(p1.specialAttack(p2));
	System.out.println();
	
	System.out.println(p2.attack(p3));
	System.out.println(p2.specialAttack(p3));
	System.out.println();
	
	System.out.println(p3.attack(p4));
	System.out.println(p3.specialAttack(p4));
	System.out.println();
	
	System.out.println(p4.attack(p1));
	System.out.println(p4.specialAttack(p1));
	System.out.println();
	
	System.out.println(p1.getStats());
	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();
    }
}
/*
public class Driver{
    public static void main(String[]args){
	Adventurer a= new Adventurer("Chadwick");
	Warrior b = new Warrior("Grobnar");
	Wizard c= new Wizard("Merlin");
	Rogue d= new Rogue("Inigo Montoya");
	
	System.out.println(a.getStats());
	System.out.println(b.getStats());
	System.out.println(c.getStats());
	System.out.println(d.getStats());
	//System.out.println(a.hit(b,.7));
	//System.out.println(b.hit(a,.5));

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
*/
