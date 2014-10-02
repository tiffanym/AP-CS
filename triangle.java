//continued from (and main file in) Stars.java
public class triangle{
	public static String triback(int n){
		String ans="";
		int i=0;
		while (i<=n){
			//mult function in Stars.java file
			ans +=mult(" ", n - i) + mult("*",i) + "\n";
			i++;
		}
		return ans;
	}
}
