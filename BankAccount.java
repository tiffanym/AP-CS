public class BankAccount{
    //instance variables
    private int balance;
    private int account;
    private String username;
    private String password;
    private int pin;
    //1.constructors
    public BankAccount(int balance, int account, String username,String password,
		       int pin){
	this.balance = balance;
	this.account = account;
	this.username = username;
	this.password = password;
	this.pin = pin;
    }
    public BankAccount(){
    }
    //2.set methods
    public void setbalance(int balance){
	this.balance = balance;
    }
    public void setaccount(int account){
	this.account = account;
    }
    public void setuser(String username){
	this.username = username;
    }
    public void setpass(String password){
	this.password=password;
    }
    public void setpin(int pin){
	this.pin=pin;
    }
    //3.method to deposit money to account
    public void deposit(int newmoney){
	setbalance(balance + newmoney);
    }
    //4.method to w/draw $--> true if successful, false otherwise
    public String withdraw(int newmoney){
	int x= (balance - newmoney);
	if (x > 0){
	    setbalance(x);
	    return "true";
	}
	else{
	    return "false";
	}
    }
    //5.print method showing all info
    public String myinfo(){
	return "Balance: "+balance+", Account #: "+account+", Username: "+username+
	    ", Password: "+password+", PIN: "+pin;
    }
    //6.toSTring method that returns "Name     Account#     Balance"
    public String toString(){
	return "Name: "+username+"     Account#: "+account+"     Balance: "+balance;
    }
    //7.main method to test code
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
