import java.util.Scanner;


public class Kmp
{
   public static void main(String ...args)
   {
        System.out.println("Please enter the para from which to search : ");
        String text ;
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        System.out.println("Hello : "+text.length());
        System.out.println("Please enter the text to match");
		String match = sc.nextLine();
	    KmpMatcher kmp= new KmpMatcher();
        kmp.suffixArray(match);		
   }

}

class KmpMatcher{
    
    int array[];	
    void suffixArray(String match)
	 {   int l=match.length();
	     array = new int[l];
         int i=0;int j=1; array[0] = 0 ; //array[l-1]=-1;
		 char matchar[]= match.toCharArray();
		 while(j<l)
		 {
		    if(matchar[i]==matchar[j]) array[j++] = ++i;
            else
			{
		        if(i==0) array[j++] = 0;
				else i= array[--i];				
			}				
		 }
		 System.out.println(" Datas");
		 for(int k=0;k<l;k++)
		 {
		    System.out.print(array[k]+" , ");
		 }
         		 
	 }

}

/*
sdkjfhdfshdkhdfasdhfkadfhakfhAdf

acacabacacabacacac

abcdefxcdbabcdnpxcdbxkabyk

*/