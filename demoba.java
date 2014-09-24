public class demoba{
    public static void main(String[]args){
	BankAccount a,b;
	a = new BankAccount();
	b = new BankAccount(0,1,"bob","hi",1234);
	a.setbalance (2);
	a.setaccount(12);
	a.setuser("anne");
	a.setpass("hello");
	a.setpin(5432);
	/*System.out.println(a);
	System.out.println(b);
	*/
	a.withdraw(5);
	System.out.println(a.myinfo());
	System.out.println(b.myinfo());

    }
}
