public class BankAccount{
    //instance variables
    private double balance;
    private int account;
    private String username;
    private String password;
    private int pin;
    //1.constructors
    public BankAccount(int balance, int account, String username,String password,
		       int pin){
	/*
	this.balance = balance;
	this.account = account;
	this.username = username;
	this.password = password;
	this.pin = pin;
	*/
	setbalance(balance);
	setaccount(account);
	setuser(username);
	setpass(password);
	setpin(pin);
    }
    public BankAccount(){
    }

    //checking account number
    public boolean checkacct(int acct){
	return ((acct >=100000000) && (acct <999999999));
    }

    //2.set methods
    public void setbalance(double balance){
	this.balance = balance;
    }
    public String setaccount(int acct){
	if (acct>=100000000 && acct<999999999){
	    account = acct;
	    return "Account number set";
	}
	else{
	    account=999999999;
	    return "Error: parameter not a valid account number";
	}
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
    public String deposit(double newmoney){
	if (newmoney>0){
	    setbalance(balance + newmoney);
	    return "Yay! More money! Deposit successful";
	}
	return "I wouldn't be adding debt if I were you. Deposit failed.";
    }
    //4.method to w/draw $--> true if successful, false otherwise
    public String withdraw(double newmoney){
	double x= (balance - newmoney);
	/*
	if (x > 0){
	    setbalance(x);
	    return "true";
	}
	else{
	    return "false";
	}
	*/
	if (x>0){
	    if (newmoney>0){
		balance=x;
		return "Withdraw successful";
	    }
	    return "Cannot withdraw negative. Withdraw failed.";
	}
	else{
	    return "Error: Not enough balance. Withdraw failed.";
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

    //authenticate method; verify account and password
    public boolean authenticate(int account, String password){
	return (this.account==account && this.password==password);
    }


    //7.main method to test code
    public static void main(String[]args){
	BankAccount a,b;
	a = new BankAccount();
	b = new BankAccount(0,1,"bob","hi",1234);
	a.setbalance (10);
	a.setaccount(738291837);
	a.setuser("anne");
	a.setpass("hello");
	a.setpin(5432);
	/*
	System.out.println(a);
	System.out.println(b);
	System.out.println("Can a withdraw money?: "+a.withdraw(5));
	System.out.println("Can b withdraw money?: "+b.withdraw(5));
	System.out.println(a.myinfo());
	System.out.println(b.myinfo());
	System.out.println(a.toString());
	System.out.println(b.toString());
	*/
	//System.out.println(a.toString());
	//System.out.println(a.withdraw(-55));
	//System.out.println(a.deposit(-42));
	System.out.println(a.authenticate(73829187, "hello"));
	
    }
}
