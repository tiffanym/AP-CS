import java.util.Scanner;
public class Game{
    //this is pause/wait code so stuff doesn't print all at once
    //from www.dreamincode.net/forums/topic/220210-is-there-a-way-to-set-a-delay-between-showing-outputs/
    public static void pause(int n){
	try{
	    Thread.sleep(1000*n);//wait n seconds
	}
	catch(InterruptedException e){
	    e.printStackTrace();
	}
    }
    

    //user picks a name for character and generates class
    public static Adventurer userSelectClass(){
	Adventurer player=null;
	Scanner in=new Scanner(System.in);
	String selection;
	System.out.println("What is your name?");
	String name=in.nextLine();
	boolean done=false;
	do{
	    System.out.println("Choose a class: \nA : Warrior \nB : Wizard \n"+"C : Rogue \n"+"D : Martial Artist");
	    selection=in.nextLine().toUpperCase();
	    if (selection.equals("A")){
		System.out.println("You picked Warrior.\n");
		player=new Warrior(name);
		done=true;
	    }
	    else if (selection.equals("B")){
		System.out.println("You picked Wizard.\n");
		player=new Wizard(name);
		done=true;
	    }
	    else if (selection.equals("C")){
		System.out.println("You picked Rogue.\n");
		player=new Rogue(name);
		done=true;
	    }
	    else if(selection.equals("D")){
		System.out.println("You picked Martial Arist.\n");
		player=new MartialArtist(name);
		done=true;
	    }
	    else{
		done=false;
	    }
	}while (!done);
	return player;
    }

    //same as opponentGenerate but creating a new player; for combat thing where you're making a team of players
    //too confusing to change opponentGenerate()'s name at this point
    //and also names are a lot nicer, or at least less... evil... sounding... O.o
    public static Adventurer playerGenerate(){
	Adventurer player=null;
	int playernumber;
	int timesset=0;
	//boolean done=(timesset<3);
	String[] warriors={"Mortimus the Mighty","Maximus the Great","Hugo the Almighty"};
	String[] wizards={"Merlin Zippity Zap","Bob the Brilliant","Sugar, Spice and Everything NICE"};
	String[] rogues={"Monty Python","Too Swayze For You","Dancing Doodle"};
	String[] martists={"Master Sensei","Hammurabi Code","Eye of the Broccoli Chance"};
	do{
	    playernumber=(int)(Math.random()*3.99)+1;
	    if (playernumber==1){
		int x=(int)(Math.random()+2);
		player=new Warrior(warriors[x]);
		timesset+=1;
	    }
	    else if(playernumber==2){
		int x=(int)(Math.random()+2);
		player=new Wizard(wizards[x]);
		timesset+=1;
	    }
	    else if(playernumber==3){
		int x=(int)(Math.random()+2);
		player=new Rogue(rogues[x]);
		timesset+=1;	       
	    }
	    else if(playernumber==4){
		int x=(int)(Math.random()+2);
		player=new MartialArtist(martists[x]);
		timesset+=1;
	    }
	    else{
		timesset=timesset;
	    }
	}while(timesset<2);
	return player;
    }

    //opponent randomly chosen as Warrior/Wizard/Rogue/Adventurer
    public static Adventurer opponentGenerate(){
	Adventurer opponent=null;
	int opponentnumber;
	boolean done=false;
	do{
	    opponentnumber=(int)(Math.random()*3.99)+1;
	    if (opponentnumber==1){
		opponent=new Warrior("Maximus Evil");
		done=true;
	    }
	    else if(opponentnumber==2){
		opponent=new Wizard("Merlindine Evil");
		done=true;
	    }
	    else if(opponentnumber==3){
		opponent=new Rogue("Roobiedaloo Evil");
		done=true;
	    }
	    else if(opponentnumber==4){
		opponent=new MartialArtist("Hwayah!!! Evil");
		done=true;
	    }
	    else{
		//opponent=new Adventurer("Some-guy-on-the-street Evil");
		done=false;
	    }
	}while(!done);
	return opponent;
    }

    public static int checkINTinput(int min, int max){
	Scanner in=new Scanner(System.in);
	int add=in.nextInt();
	while (add>max || add<min){
	    System.out.println("ERROR Please enter a number between "+min+" and "+max);
	    add=in.nextInt();
	}
	return add;
    }

    //player can allocate 30 stat points b/w their STR/DEX/INT
    public static void assignBonusStats(Adventurer player, int bonusStats){
	System.out.println("Here are your current stats:\n"+player.getStats()+"\n");
	pause(1);
	System.out.println("You have "+bonusStats+" stat points to distribute b/w STR/DEX/INT");	

	//adds to STR stat
	System.out.println("How many points would you like to add to STR?");
	int addSTR= checkINTinput(0,bonusStats);
	player.setSTR(player.getSTR()+addSTR);
	bonusStats=bonusStats-addSTR;
	System.out.println("You have added "+addSTR+" stat points to STR. \n"+"=>Your strength is now "+player.getSTR()+".\n");
	
	pause(1);

	if (bonusStats>0){
	    //adds to DEX stat
	    System.out.println("You have "+bonusStats+" stat points to distribute b/w DEX and INT");
	    pause(1);
	    System.out.println("How many points would you like to add to DEX?");
	    int addDEX=checkINTinput(0,bonusStats);
	    player.setDEX(player.getDEX()+addDEX);
	    bonusStats=bonusStats-addDEX;
	    System.out.println("You have added "+addDEX+" stat points to DEX. \n"+"=>Your dexterity is now "+player.getDEX()+".\n");	    
	    
	    pause(1);

	    if (bonusStats>0){
		//adds rest of bonusStatsto INT
		player.setINT(player.getINT()+bonusStats);
		System.out.println(bonusStats+" stat points have been added to INT. \n"+"=>Your intelligence is now "+player.getINT()+".");
		bonusStats=0;
	    }
	    else{
		System.out.println("You left nothing for INT. :( \n"+"Your intelligence is now "+player.getINT()+".");
	    }
	}
	else{
	    System.out.println("You have allocated all your stat points to STR, and so none are left for DEX or INT. :'(");
	}

	pause(1);

	System.out.println("\nHere are your updated stats:\n"+player.getStats()+"\n");
    }

    //creates new character
    public static Adventurer userGenerateCharacter(){
	Adventurer player=userSelectClass();
	player.setSTR(10);
	player.setDEX(10);
	player.setINT(10);
	assignBonusStats(player, 27);
	return player;
    }

    //checks readiness/ "Are you still alive right now"-ness
    public static void readyornot(){
	Scanner readyscan=new Scanner(System.in);
	System.out.println("\nAre you ready? [Y/N]");
	String ready;
	boolean done=false;
	do{
	    ready=readyscan.nextLine().toUpperCase();
	    if (ready.equals("Y")){
		System.out.println("Awesome! Let's get started: \n");
		done=true;
	    }
	    else if(ready.equals("N")){
		System.out.println("Too bad. You signed up for this, so stop complaining. >:-) \n");
		done=true;
	    }
	    else{
		System.out.println("C'mon. Put in something legit, will ya?");
		done=false;
	    }
	}while (!done);
    }

    public static void playerattackmode(Adventurer player, Adventurer opponent){
	Scanner in=new Scanner(System.in);
	System.out.println(player.getName()+"\nChoose an action: \n"+"A : attack \n"+"B : special attack \n"+"C : give up");
	String action=in.nextLine().toUpperCase();
	while ("ABC".indexOf(action.toUpperCase())==-1){
	    System.out.println("ERROR Please enter a valid option.");
	    System.out.println();
	    System.out.println("Choose an action: \n"+"A : attack \n"+"B : special attack \n"+"C : give up");
	    action = in.nextLine().toUpperCase();
	}
	if (action.equals("A")){
	    System.out.println(player.attack(opponent));
	    pause(1);
	}
	else if (action.equals("B")){
	    System.out.println(player.specialAttack(opponent));
	    pause(1);
	}
	else if (action.equals("C")){
	    System.out.println("How lazy. What kind of true player gives up? Fine, I'll let it go this time.");
	    int x=(int)(Math.random()*8)+1;
	    player.setHP(player.getHP()+x);
	    System.out.println("=>"+player.getName()+" did not move and regained "+x+" HP.");
	    pause(1);
	}
    }
    
    public static void opponentattacks(Adventurer player, Adventurer opponent){
	int willoppatk=(int)(Math.random()*2)+1;
	if (willoppatk==1){
	    System.out.println(opponent.attack(player)+"\n");
	}
	else{
	    System.out.println(opponent.specialAttack(player)+"\n");
	}
	pause(1);	 
    }

    public static Adventurer[] defOrCust(Adventurer player){
	Scanner in=new Scanner(System.in);
	System.out.println("BEFORE THE BATTLE BEGINS:\n"+"You will be part of a team of three.\n"+"HOW WOULD YOU LIKE TO CREATE YOUR TEAM?\n"+
			   "A : USE DEFAULT TEAM\n"+"B : MAKE MY CUSTOM TEAM");
	String DefOrCust;
	Adventurer[] team=new Adventurer[3];
	team[0]=player;
	boolean done=false;
	do{
	    DefOrCust=in.nextLine().toUpperCase();
	    if (DefOrCust.equals("A")){
		for (int i=1;i<3;i++){	
		    team[i]=playerGenerate();
		}
		done=true;
	    }
	    else if(DefOrCust.equals("B")){
		for (int i=1;i<3;i++){
		    System.out.println("=>Controlled Minion "+i+"<=");
		    team[i]=userGenerateCharacter();
		}
		done=false;
		break;
	    }
	    else{
		System.out.println("ERROR: Please enter a valid option.");
		done=false;
	    }
	}while(!done);
	return team;
    }

    public static void combat(Adventurer[] playerteam, Adventurer opponent){
	readyornot();
	pause(1);
	System.out.println(playerteam[0].getName()+"'s TEAM:");	
	for (int i=0;i<playerteam.length;i++){
	    System.out.println(playerteam[i].getName());
	}
	System.out.println("\nvs.\n\nTHAT OTHER GUY:\n"+opponent.getName()+"\n");
	pause(1);
	boolean playerteamstillalive=true;
	boolean opponentalive=true;
	do{
	    for (int i=0;i<playerteam.length;i++){
		playerteamstillalive=((playerteam[0].getHP()>0) || (playerteam[1].getHP()>0) || (playerteam[2].getHP()>0));
		opponentalive=(opponent.getHP()>0);

		if (opponentalive){
		    System.out.println("=>YOUR TEAM<=");
		    for (int x=0; x<playerteam.length;x++){
			System.out.println(playerteam[x].getStats());
		    }
		    System.out.println("=>ENEMY'S TEAM<=\n"+opponent.getStats());
		    System.out.println();
		    playerattackmode(playerteam[i],opponent);
		    opponentattacks(playerteam[i],opponent);
		}
		else{
		    break;
		}	   
	    }
	}while (playerteamstillalive && opponentalive);

	//announcing results
	if (opponent.getHP()<=0){
	    System.out.println("Yay! "+playerteam[0].getName()+"'s team won!!!");
	}
	else if (!playerteamstillalive){
	    System.out.println("Aw, "+playerteam[0].getName()+" lost. :'("+ "\n"+"Well boo-hoo for you, but somebody (a.k.a. "+opponent.getName()+") is going home a winner!!!! \n"+"I mean.... uh... everyone's a winner? ^v^;");
	}
	
    }

    //makes a copy of the original team should the player wish to fight again
    public static Adventurer[] backUp(Adventurer[] team){
	Adventurer[] newteam= new Adventurer[team.length];
	for (int i=0;i<team.length;i++){
	    newteam[i]=team[i].clone();
	}
	return newteam;
    }

    public static void combatmode(Adventurer player, Adventurer opponent){
	Adventurer[] team=defOrCust(player);
	Adventurer[] backUpTeam= backUp(team);
	Adventurer newOpponent=opponentGenerate();
	combat(team,opponent);

	//asking for another round?
	Scanner in=new Scanner(System.in);
	System.out.println("What do you want to do now?\n"+"A : STOP\n"+"B : FIGHT AGAIN");
	String answer;	
	boolean done=false;
	do{
	    answer=in.nextLine().toUpperCase();
	    if(answer.equals("A")){
		System.exit(0);
		done=true;
	    }
	    else if(answer.equals("B")){
		combat(backUpTeam,newOpponent);
		done=true;
	    }
	    else{
		System.out.println("ERROR: Please enter a valid option.");
		done=false;
	    }
	}while(!done);
	done=false;	
    }

    public static void main(String[]args){
	System.out.println("==***WELCOME TO STUYABLO***==");
	System.out.println("=**CREATE YOUR CHARACTER**=");
	Adventurer player=userGenerateCharacter();
	Adventurer opponent=opponentGenerate();
	pause(1);
	//	combat(defOrCust(player),opponent);
	combatmode(player, opponent);
    }
}
