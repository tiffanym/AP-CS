import java.util.Scanner;
public class Game{
	public static Adventurer combat(Adventurer[]player, Adventurer opponent){
		Scanner in=new Scanner();
		System.out.println("How many characters do you want to go against "+opponent.getName()+"?");
		int n=in.nextInt;
		int[]playerArray;
		playerArray=[n];
		i=0;
		do{
			
		
		}while(i<n);
		
	}

    public static void main(String[]args){
	Adventurer player,opponent;	
	//user picks their class/ Adventurer type
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
	    System.out.println("You picked Warrior.\n");
	    player=new Warrior();
	    //(Warrior)player;
	}
	else if (playerclass.equals("B")){
	    System.out.println("You picked Wizard.\n");
	    player=new Wizard();
	    //(Wizard)player;
	}
	else if (playerclass.equals("C")){
	    System.out.println("You picked Rogue.\n");
	    player=new Rogue();
	    //(Rogue)player;
	}
	else{
	    player=new Adventurer();
	}

	//opponent randomly chosen as Warrior/Wizard/Rogue/Adventurer
	int opponentnumber=(int)(Math.random()*4)+1;
	if (opponentnumber==1){
	    opponent=new Warrior("Maximus, the Evil Thing");
	}
	else if(opponentnumber==2){
	    opponent=new Wizard("Merlindine, the Evil Thing");
	}
	else if(opponentnumber==3){
	    opponent=new Rogue("Roobiedaloo, the Evil Thing");
	}
	else{
	    opponent=new Adventurer("Some Guy on the Street, the Evil Thing");
	}
	
	//user picks their name
	Scanner namescan=new Scanner(System.in);
	System.out.println("What is your name?");
	String name=namescan.nextLine();
	player.setName(name);
	System.out.println("*Salutes* I welcome you "+name+".\n");
	//this is pause/wait code so stuff doesn't print all at once
	//from www.dreamincode.net/forums/topic/220210-is-there-a-way-to-set-a-delay-between-showing-outputs/
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	//player can "create" character y allocating 30 stat points b/w their STR/DEX/INT
	System.out.println("Here are your current stats:");
	System.out.println(player.getStats());
	System.out.println();
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	System.out.println("You have 30 stat points to distribute b/w STR/DEX/INT");
	int x=30;
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	//adds to STR stat
	Scanner allocateSTR=new Scanner(System.in);
	System.out.println("How many points would you like to add to STR?");
	int addSTR=allocateSTR.nextInt();
	while (addSTR>x || addSTR<0){
	    System.out.println("ERROR Please enter a number between 0 and 30");
	    System.out.println("How many point would you like to add to STR?");
	    addSTR=allocateSTR.nextInt();
	}
	x=x-addSTR;
	player.setSTR(player.getSTR()+addSTR);
	System.out.println("You have added "+addSTR+" stat points to STR. \n"+" Your strength is now "+player.getSTR()+".");
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	if (x>0){
	    //adds to DEX stat
	    System.out.println("You have "+x+" stat points to distribute b/w DEX and INT");
	    //this is pause/wait code so stuff doesn't print all at once
	    try{
		Thread.sleep(1000);//wait a second
	    }
	    catch(InterruptedException e){
		e.printStackTrace();
	    }
	    Scanner allocateDEX=new Scanner(System.in);
	    System.out.println("How many points would you like to add to DEX?");
	    int addDEX=allocateDEX.nextInt();
	    while (addDEX>x || addDEX<0){
		System.out.println("ERROR Please enter a number between 0 and "+x);
		System.out.println("How many point would you like to add to DEX?");
		addDEX=allocateDEX.nextInt();		
	    }
	    x=x-addDEX;
	    player.setDEX(player.getDEX()+addDEX);
	    System.out.println("You have added "+addDEX+" stat points to DEX. \n"+" Your dexterity is now "+player.getDEX()+".");	    
	    //this is pause/wait code so stuff doesn't print all at once
	    try{
		Thread.sleep(1000);//wait a second
	    }
	    catch(InterruptedException e){
		e.printStackTrace();
	    }
	    if (x>0){
		//adds to INT
		System.out.println("You have "+x+ " stat points to distribute to INT");
		Scanner resttoINTq=new Scanner(System.in);
		//asks if wants to add all points left to INT
		System.out.println("Would you like to distribute your remaining points to INT? [Y/N]");
		String resttoINTa=resttoINTq.nextLine().toUpperCase();
		//adds all leftover points to INT
		if (resttoINTa.equals("Y")){
		    player.setINT(player.getINT()+x);
		    System.out.println("You have added "+x+ " stat points to INT. \n"+"Your intelligence is now "+player.getINT()+".");
		    x=0;
		}
		//adds certain number of leftover points to INT
		else if (resttoINTa.equals("N")){
		    Scanner allocateINT=new Scanner(System.in);
		    System.out.println("How many points would you like to add to INT?");
		    int addINT=allocateINT.nextInt();
		    while (addINT>x || addINT<0){
			System.out.println("ERROR Please enter a number between 0 and "+x);
			System.out.println("How many point would you like to add to INT?");
			addINT=allocateINT.nextInt();		
		    }
		    x=x-addINT;
		    player.setINT(player.getINT()+addINT);
		    System.out.println("You have added "+addINT+" stat points to INT. \n"+"Your intelligence is now "+player.getINT()+".");
		    System.out.println();
		    //this is pause/wait code so stuff doesn't print all at once
		    try{
			Thread.sleep(1000);//wait a second
		    }
		    catch(InterruptedException e){
			e.printStackTrace();
		    }
		    //checking to make sure player wants to add any leftover points or leave it as is
		    Scanner whattodowithrest=new Scanner(System.in);
		    System.out.println("Are you sure you don't want to allocate the rest of your points to one of the stats? \n"+
				       "You still have "+x+" stat points left to use. \n"+
				       "Whaddya say? \n"+
				       "A : Add the rest of my points to STR \n"+
				       "B : Add the rest of my points to DEX \n"+
				       "C : Add the rest of my points to INT \n"+
				       "D : LEAVE ME ALONE AND LET ME PLAY THE GAME!!!");
		    String response=whattodowithrest.nextLine().toUpperCase();
		    while ("ABCD".indexOf(response.toUpperCase())==-1){
			System.out.println("ERROR Please enter a valid option.");
			System.out.println();
			System.out.println("Choose one of the options below: \n"+
					   "A : Add the rest of my points to STR \n"+
					   "B : Add the rest of my points to DEX \n"+
					   "C : Add the rest of my points to INT \n"+
					   "D : LEAVE ME ALONE AND LET ME PLAY THE GAME!!!");
			response = whattodowithrest.nextLine();
		    }
		    if (response.equals("A")){
			int newAddSTR=x;
			player.setSTR(player.getSTR()+newAddSTR);
			System.out.println("You have added "+newAddSTR+" stat points to STR. \n"+" Your strength is now "+player.getSTR()+".");
			//this is pause/wait code so stuff doesn't print all at once
			try{
			    Thread.sleep(1000);//wait a second
			}
			catch(InterruptedException e){
			    e.printStackTrace();
			}
		    }
		    else if (response.equals("B")){
			int newAddDEX=x;
			player.setDEX(player.getDEX()+newAddDEX);
			System.out.println("You have added "+newAddDEX+" stat points to DEX. \n"+" Your dexterity is now "+player.getDEX()+".");
			//this is pause/wait code so stuff doesn't print all at once
			try{
			    Thread.sleep(1000);//wait a second
			}
			catch(InterruptedException e){
			    e.printStackTrace();
			}
		    }
		    else if (response.equals("C")){
			int newAddINT=x;
			player.setINT(player.getINT()+newAddINT);
			System.out.println("You have added "+newAddINT+" stat points to INT. \n"+" Your intelligence is now "+player.getINT()+".");
			//this is pause/wait code so stuff doesn't print all at once
			try{
			    Thread.sleep(1000);//wait a second
			}
			catch(InterruptedException e){
			    e.printStackTrace();
			}
		    }
		    else if (response.equals("D")){
			System.out.println("Okay, okay, geez."+ "\n *Sooomeone's got anger issues O_O*");
			//this is pause/wait code so stuff doesn't print all at once
			try{
			    Thread.sleep(1000);//wait a second
			}
			catch(InterruptedException e){
			    e.printStackTrace();
			}			
		    }
		}
	    }
	}
	else{
	    System.out.println("You have allocated all your stat points to STR, and so none are left for DEX or INT. :'(");
	}
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	System.out.println("Here are your updated stats:");
	System.out.println(player.getStats());
	System.out.println();	

	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	//Player and Opponent now in combat mode
	System.out.println("You, "+name+", will be going against "+opponent.getName()+". \n");
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	//checks readiness/ "Are you still alive right now"-ness
	Scanner readyscan=new Scanner(System.in);
	System.out.println("Are you ready? [Y/N]");
	String ready=readyscan.nextLine().toUpperCase();
	if (ready.equals("Y")){
	    System.out.println("Awesome! Let's get started: \n");
	}
	else if(ready.equals("N")){
	    System.out.println("Too bad. You signed up for this, so stop complaining. >:-) \n");
	}

	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	System.out.println("Out of courtesy, opponent will allow "+player.getName() +" to go first. \n");
	//this is pause/wait code so stuff doesn't print all at once
	try{
	    Thread.sleep(1000);//wait a second
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
	//lists stats
	while (player.getHP()>0 && opponent.getHP()>0){
	    System.out.println(player.getStats());
	    System.out.println(opponent.getStats());
	    System.out.println();
	    //player attacks
	    Scanner actionscan=new Scanner(System.in);
	    System.out.println("Choose an action: \n"+"A : attack \n"+"B : special attack \n"+"C : give up");
	    String action=actionscan.nextLine().toUpperCase();
	    while ("ABC".indexOf(action.toUpperCase())==-1){
		System.out.println("ERROR Please enter a valid option.");
		System.out.println();
		System.out.println("Choose an action: \n"+"A : attack \n"+"B : special attack \n"+"C : give up");
		action = actionscan.nextLine();
	    }
	    if (action.equals("A")){
		System.out.println(player.attack(opponent));
		//this is pause/wait code so stuff doesn't print all at once
		try{
		    Thread.sleep(1000);//wait a second
		}
		catch(InterruptedException e){
		    e.printStackTrace();
		}
	    }
	    else if (action.equals("B")){
		System.out.println(player.specialAttack(opponent));
		//this is pause/wait code so stuff doesn't print all at once
		try{
		    Thread.sleep(1000);//wait a second
		}
		catch(InterruptedException e){
		    e.printStackTrace();
		}
	    }
	    else if (action.equals("C")){
		System.out.println("How lazy. What kind of true player gives up? Fine, I'll let it go this time.");
		//this is pause/wait code so stuff doesn't print all at once
		try{
		    Thread.sleep(1000);//wait a second
		}
		catch(InterruptedException e){
		    e.printStackTrace();
		}
	    }
	    //opponent attacks
	    //String oppclass=opponent.getClass().getSimpleName();
	    int willoppatk=(int)(Math.random()*2)+1;
	    if (willoppatk==1){
		System.out.println(opponent.attack(player)+"\n");
	    }
	    else{
		System.out.println(opponent.specialAttack(player)+"\n");
	    }

	    //this is pause/wait code so stuff doesn't print all at once
	    try{
		Thread.sleep(1000);//wait a second
	    }
	    catch(InterruptedException e){
		e.printStackTrace();
	    }
	   
	}
	//announcing results
	if (opponent.getHP()<=0){
	    System.out.println("Yay! "+player.getName()+" won!!!");
	}
	else if (player.getHP()<=0){
	    System.out.println("Aw, "+player.getName()+" lost. :'("+ "\n"+"Well boo-hoo for you, but somebody (a.k.a. "+opponent.getName()+") is going home a winner!!!! \n"+"I mean.... uh... everyone's a winner? ^v^;");
	}

    }
}
