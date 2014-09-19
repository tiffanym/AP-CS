public class PersonalGreeter{
	private String greeting;
	private String name;

	//constructors
	public PersonalGreeter(String name, String greeting){
		setname(name);
		setgreet(greeting);
	}
	public PersonalGreeter(String name){
		setgreet("Hello");
		setname(name);
	}
	public PersonalGreeter(){
		setgreet("Hello");
		setname("Bob");
	}

	//get methods for instance variables
	public String getgreet(){
		return greeting;
	}
	public String getname(){
		return name;
	}

	//set methods for instance variables
	public void setgreet(String greeting){
		this.greeting=greeting;
	}
	public void setname(String name){
		this.name=name;
	}

	public String greet(){
		//return greeting+" "+name;
		return getgreet()+" "+getname();
	}
}
