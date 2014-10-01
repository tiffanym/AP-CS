public class Stars{

    public static String rect(int height, int width){
	String s="";
	int i=0;
	while (i<height){
	    int across=0;
	    while (across<width){
		s=s+"*";
		across+=1;
	    }
	    s+="\n";
	    i+=1;
	}
	return s;
    }

    public static void main(String[]args){
	System.out.println(rect(2,3));
	System.out.println(rect(3,2));
	System.out.println(rect(4,4));
    }
}
