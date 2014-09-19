public class demopg{
	public static void main(String[]args){
		PersonalGreeter a,b,c;
		a = new PersonalGreeter("Amy","Hola");
		b= new PersonalGreeter("Amy");
		c = new PersonalGreeter();
		/*
		System.out.println(a.getgreet());
		a.setgreet("Hi");
		a.setname("Bob");
		System.out.println(a.getgreet());
		System.out.println(a.getname());
		*/
		System.out.println(a.greet());
		System.out.println(b.greet());
		System.out.println(c.greet());
	}
}
