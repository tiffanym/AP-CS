public class triangles{

    public static String tri(int size){
	String s="";
	int i=1;
	while (i<size+1){
	    int across=0;
	    while (across<i){
		s=s+"*";
		across=across+1;
	    }
	    s+="\n";
	    i+=1;
	}
	return s;
    }

    public static String triBack(int size){
	String s="";
	int height=1;
	while (height<size+1){
	    int across=size-height;
	    while (across<size &&across>0){
		s=s+" ";
		across=across-1;
	    }
	    
	    int star=across+height;
	    int counts=0;
	    while (counts<star){
		s+="*";
		counts+=1;
	    }
	    s+="\n";
	    height+=1;
	}
	return s;
    }

    public static void main(String[]args){
	//System.out.println(tri(3));
	//System.out.println(tri(5));
	//System.out.println(tri(13));
	System.out.println(triBack(3));
	System.out.println(triBack(5));
	System.out.println(triBack(8));
    }
}
