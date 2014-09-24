public class demoba{
    public static void main(String[]args){
	BankAccount a,b;
	a = new BankAccount();
	b = new BankAccount(0,1,"bob","hi",1234);
	a.setbalance (10);
	a.setaccount(12);
	a.setuser("anne");
	a.setpass("hello");
	a.setpin(5432);
	/*System.out.println(a);
	System.out.println(b);
	*/
	System.out.println("Can a withdraw money?: "+a.withdraw(5));
	System.out.println("Can b withdraw money?: "+b.withdraw(5));
	System.out.println(a.myinfo());
	System.out.println(b.myinfo());
	System.out.println(a.toString());
	System.out.println(b.toString());
    }
}
