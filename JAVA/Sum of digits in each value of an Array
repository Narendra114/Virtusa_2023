import java.util.*;
public class Main
{
    public static int value(int a)
    {
        int dig,sum=0;
        while(a!=0)
        {
            dig=a%10;
            sum=sum+dig;
            a=a/10;
        }
        return sum;
    }
	public static void main(String[] args) {
	    try(Scanner scan=new Scanner(System.in)){
	     int n=scan.nextInt();
	     int[] a=new int[n];
	     int i;
	     for(i=0;i<n;a[i++]=scan.nextInt());
	     for(i=0;i<n;i++)
	     {
	         System.out.print(value(a[i])+" ");
	     }
	    }
	}
}
