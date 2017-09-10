import java.util.Scanner;
import java.util.Random;

public class BubbleSort
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
		myBubbleSort mq= new myBubbleSort();
		mq.sort(array,n-1);
		System.out.print("\nSorted array : \n");
		for(int i=0;i<n;i++)
		{
			System.out.print(array[i]+" , ");
		}
		
	}
	
}

class myBubbleSort
{  
	void sort(int array[],int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i;j++)
			{
				if(array[j]>array[j+1])
				{
					int temp= array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
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


