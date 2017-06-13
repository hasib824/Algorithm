import java.util.Scanner;


public class Kmp
{
   public static void main(String ...args)
   {
        System.out.println("Please enter the text from which to search : ");
        String text ;
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        System.out.println("Hello : "+text.length());
        System.out.println("Please enter the pattern to match");
		String match = sc.nextLine();
	    KmpMatcher kmp= new KmpMatcher();
        kmp.suffixArray(match);		
        kmp.kmp(text,match);		
   }

}

class KmpMatcher{
    
    int array[];	
    void suffixArray(String match)
	 {   int l=match.length();
	     array = new int[l];
         int i=0;int j=1; array[0] = 0;
		 char matchar[]= match.toCharArray();
		 while(j<l) // do until last index of pattern
		 {
		    if(matchar[i]==matchar[j]) array[j++] = ++i; // if match found check for next charcter , both suffix and prefix
            else       // if not match
			{
		        if(i==0) array[j++] = 0; // if suffix is in index zero and not match then array filled by "0" 
				else i= array[--i];		// if suffix not index zero and not match then look for previous pattern that matched		
			}				
		 }
	 
	 }
	 
	 void kmp(String tex,String ma)
	 {  
	    int l_text= tex.length(); int l_match= ma.length();
	    char text []= tex.toCharArray();
		char match []= ma.toCharArray();		
		int i=0 ; int j=0; int cnt=0;
		while(j<l_text) // serch until the end if the text
		{
		  if(match[i]==text[j]) { i++; j++; } // if match found increase both array index
          else                                // if no match
		   {
	         if(i==0) j++;            //  if pattern's index is zero then check next character of text   
             else i=array[--i];		 // if patterns index non zero then go to last matched pattern index 	 
		   }
          if(i==l_match) { cnt++; i=0;}	// if end+1 of 	pattern then match found and try for 2nd occurence   
		}		
		System.out.println("Occurences : " + cnt + " times ");
	 }

}

/*
acacabacacabacacacafgsadfacacabacabacacacdfff
acacabacacabacacac

abcdefxcdbabcdnpxcdbxkabyk

*/