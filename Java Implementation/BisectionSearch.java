import java.util.Scanner;

public class BisectionSearch{
  
  public static void main(String ...args)
  {    
	   Scanner sc = new Scanner(System.in);
	   System.out.println(" Please enter number to calculate SquareRoot :  ");
	   Double num = sc.nextDouble();
	   SquareRoot sq= new SquareRoot();
	   System.out.println(num + " SquareRoot : "+sq.get(num));
  }
}

class SquareRoot
{
    Double get(double num)
	{  
	    double low=0d, high = num, mid = 0; 
		while( (high -low> .0001 ) || (high -low > .0000 ) )
		{
		     mid= (low+high)/2;
			if(mid*mid>num) high = mid;
		    else if(mid*mid == num) break; 
			else low = mid;
		}
		System.out.println(" Diff : "+ (high-low));
		return mid;
	}

}

// javac BisectionSearch.java  
// java BisectionSearch