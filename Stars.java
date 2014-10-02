public class Stars{
	
	public static String mult (String s, int n){
		String ans="";
		while (n>0){
			ans+=s;
			n--;
		}
		return ans;
	}
	
    public static String rect(int height, int width){
		String s="";
		int i=0;
		while (i<height){
	    	str+= mult("*",width)+"\n";
	    	i++;
		}
		return s;
    }

    public static void main(String[]args){
	System.out.println(rect(2,3));
	System.out.println(rect(3,2));
	System.out.println(rect(4,4));
    }
}
