import java.util.Scanner;

public class SelectionSort
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
		MySelectionSort is= new MySelectionSort();
		is.sort(array,n-1);
		System.out.print("\nSorted array : \n");
		for(int i=0;i<n;i++)
		{
			System.out.print(array[i]+" , ");
		}	  
  }
	
}
// Selection sort , time complexity O(n^2), space complexity O(1);
class MySelectionSort
{
	void sort(int A[],int n)
	{
		for(int i=0;i<=n;i++)
		{
			int minIdx = i; 
			for(int j=i+1;j<=n;j++)
			{
				if(A[j]<A[minIdx]) minIdx = j; 
			}
			int temp = A[minIdx];
			A[minIdx] = A[i];
			A[i] = temp;
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