import java.util.Scanner;
import java.util.Random;

public class QuickSort
{	
	public static void main(String ...args)
	{
		System.out.println("How many datas  ? : ");
        int n; Scanner sc= new Scanner(System.in);
        n= sc.nextInt(); int array [] = new int[n]; 
		System.out.println("Please enter datas : ");
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
		}
		
		System.out.println("Unsorted datas are : ");
		for(int i=0;i<n;i++)
		{
			System.out.print(array[i]+" , ");
		}
		MyQuickSort mq= new MyQuickSort();
		mq.sort(array,n);
		System.out.print("\nSorted array : \n");
		for(int i=0;i<n;i++)
		{
			System.out.print(array[i]+" , ");
		}
		
		
	}
	
}

class MyQuickSort
{
   int array[];
   int l;
   void sort(int array[],int l)
   {
       this.array = array; this.l = l;
        doSort(0,l-1);  	   
   }
   
   void doSort(int start,int end)
   {
	   if(start<end)
	   {
	     int pIndex = partition(start,end);
		 doSort(start,pIndex-1);
         doSort(pIndex+1,end);		 
	   }
      
   }
   int RandomizedPartition(int start,int end)
   {
		int pivot = new Random().nextInt(end-start+1)+start; // Getting Random Pivot
		int pIndex = start;
		
		for(int i=start;i<end;i++)
		{
		  if(array[i]<=pivot)
		  {
			  swap(i,pIndex);			  
			  pIndex++;
		  }
		}
		swap(pIndex,end);
		return pIndex;
   }
   
   void swap(int i,int pIndex)
   {
	   int temp= array[pIndex];
	   array[pIndex]= array[i];
	   array[i] = temp;
   }
}


/*
Test Case 
13
4 8 9 5 12 10 17 6 3 2 1 14 7


*/

