public class SuperArray{
    private Object[] data;
    private int numElements;

    public SuperArray(){
	data=new SuperArray[10];
    }

    public SuperArray(int numElements){
	this.numElements=numElements;
    }

    public String toString(){
	String s="[";
	for (int i=0;i<SuperArray.length;i++){
	    s+=" "+(String)(SuperArray);
	}
	return s;
    }

}
