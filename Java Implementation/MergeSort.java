import java.util.*;

public class MergeSort
{
  public static void main(String... args)
  {   int size;
      Scanner sc = new Scanner(System.in);
      System.out.println("How many datas : "); size = sc.nextInt();
	  ArrayList<Integer> datas= new ArrayList(size);
	  for(int i=0;i<size; i++)
	  {
	     datas.add(sc.nextInt());
	  }
	  System.out.println("Unsorted datas are : ");
	  for(int i=0;i<size; i++)
	  {
	     System.out.print(datas.get(i)+" ,  ");
	  }
	  
	  // Creating mySort Object 
	  MySort<Integer> mySort = new MySort();
	  mySort.sort(datas,size);	  
	  System.out.println("The sorted arrays are : ");	  
	  for(int i=0;i<size;i++) System.out.print(datas.get(i) + ",");
	  
	  MySort<Character> myChars = new MySort();
	  ArrayList<Character> charDatas = new ArrayList(Arrays.asList('j','a','c','b','d','g','e','f','i','h'));
	  myChars.sort(charDatas,size);
	  System.out.println("\nCharacter array : "+ charDatas.toString());
	  
	  MySort<String> myStrs = new MySort();
	  ArrayList<String> myChar = new ArrayList(Arrays.asList("abcde","abcd","b","c","a","d","de","ab","abc","ac"));
	  myStrs.sort(myChar,size);
	  System.out.println("\nString Array: "+ myChar.toString());
		  
	  
	
	 
  }
}

class MySort<T extends Comparable<T>>
{   
   
   void sort(ArrayList<T> datas,int high)
   {    
      // System.out.println("Size of datas : "+ datas.size());
       if((high)<2) 
	   {
		   return;
	   }
	   int mid = high/2;
	   ArrayList<T> left = new ArrayList(mid+1);
	   ArrayList<T> right = new ArrayList(high-mid+1);
	  // System.out.println("\nPrinting inside Merege : ");
	   for(int i=0;i<mid;i++)
	   {
	    left.add(datas.get(i));
	   }
	   for(int i=mid;i<high;i++)
	   {
	    right.add(datas.get(i));
	   }
	   
	   sort(left,mid);
	   sort(right,high-mid);
	   merge(datas,left,mid,right,high-mid);
	   
   }
   
   void merge(ArrayList<T> datas,ArrayList<T> left,int leftSize,ArrayList<T> right,int rightSize)
   {
       int i=0; int j=0;int k=0;
	   
	   while((i<leftSize) && (j<rightSize))
	   {
	       if( left.get(i).compareTo(right.get(j)) < 0)
		   {
		     datas.set(k++,left.get(i++));
		   }
		   else
		   {
		     datas.set(k++,right.get(j++));
		   }
	   }
	   while(i<leftSize)
	   {
	     datas.set(k++,left.get(i++));
	   }
	   	 while(j<rightSize)
	   {
	     datas.set(k++,right.get(j++));
	   }	   
   }
   
}
/*

10
33
10
45
7
98
65
2
65
72
32

*/