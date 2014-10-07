public class Warrior extends Adventurer{

\\ extends Adventurer is what allows us to make warriors a subclass of Adventurers.

private int rage;

\\ Only Warriors would have the rage variable where Wizards would have the mana variable so each could behave differently

public Warrior(){

        setName(“Sasuki”);   

}

\\ Warrior.java can access public methods from Adventurer.java but nothing private like variables so this is why we use the set/get methods.
}
