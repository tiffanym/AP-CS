import java.util.Scanner;
public class Game{
    Adventurer player,oppenent;
    public static void main(String[]args){
	
	Scanner scan=new Scanner(System.in);
	System.out.println("Choose a class: \n A : Warrior \n B : Wizard \n"+"C : Rogue");
	String playerclass=scan.nextLine().toUpperCase();
	
	while ("ABC".indexOf(playerclass.toUpperCase())==-1){
		System.out.println("ERROR Please enter a valid option.");
		System.out.println();
		System.out.println("Choose a class: \n"+"A : Warrior \n"+"B : Wizard \n"+"C : Rogue");
		playerclass = scan.nextLine();
	}
	if (playerclass.equals("A")){
	    System.out.println("You picked Warrior.");
	    Warrior player=new Warrior();
	}
	else if (playerclass.equals("B")){
	    System.out.println("You picked Wizard.");
	    Wizard player=new Wizard();
	}
	else if (playerclass.equals("C")){
	    System.out.println("You picked Rogue.");
	    Rogue player=new Rogue();
	}
	Adventurer opponent=new Adventurer();
    }
}
