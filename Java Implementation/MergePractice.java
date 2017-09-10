import java.util.Scanner;
import java.util.Random;

public class MergePractice
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
		MyMergeSort mq= new MyMergeSort();
		mq.sort(array,n-1);
		System.out.print("\nSorted array : \n");
		for(int i=0;i<n;i++)
		{
			System.out.print(array[i]+" , ");
		}
		
	}
	
}

class MyMergeSort
{
   void sort(int array[],int high)
   {  
      if(high<1) return;
      int mid = high/2;
      int leftArray[]=new int[mid+1];
      int rightArray[]=new int[high-mid];
	  for(int i=0;i<=mid;i++) leftArray[i]=array[i];int k=0;
	  for(int i=mid+1;i<=high;i++) rightArray[k++]=array[i];
	  sort(leftArray,mid); sort(rightArray,high-(mid+1));
	  merge(array,leftArray,mid,rightArray,high-(mid+1)); 	  
   }
   
   void merge(int mainArray[],int leftArray[],int leftHigh,int rightArray[],int rightHigh)
   {   
       int i=0, j=0,k=0; //System.out.println("What happend\n");
	   while( i<=leftHigh && j<=rightHigh)
	   {
	     if(leftArray[i]<rightArray[j]) mainArray[k++]=leftArray[i++];
	     else mainArray[k++]=rightArray[j++];
	   }
	   while(i<=leftHigh)
	   {
	      mainArray[k++]=leftArray[i++];
	   }	   
	   while(j<=rightHigh)
	   {
	      mainArray[k++]=rightArray[j++];
	   }
   }

}

/*
Test Case 
13
4 8 9 5 12 10 17 6 3 2 1 14 7

12
7 5 11 9 8 12 17 14 13 25 6 4

*/












