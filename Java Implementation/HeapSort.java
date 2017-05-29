import java.util.Scanner;
import java.util.*;

public class HeapSort
{   
	public static void main(String args[])
	{
         Scanner sc = new Scanner(System.in);
         int n; 
         printf("How many numbers ? "); 
         n = sc.nextInt();		  
      	 Integer heap[] = new Integer[n+1]; 
		 for(int i =1; i<=n; i++)
		 {
	        heap[i] = sc.nextInt(); 		 
		 }
         MyHeap mhp = new MyHeap();
         mhp.buildHeap(heap,n);         
         printf("The MaxHeap is : ",heap[1]+" ");
		 heap = mhp.sort();
		 printf("Sorted datas are : ");
		 printf(Arrays.toString(heap)+"");
	}
	
	static void  printf(String ...abc)
	{
		for(int i=0; i<abc.length; i++)
		{
			System.out.println(abc[i]);
		}
	}
}

class MyHeap
{  
   private Integer heap[];
   int size;
   void buildHeap(Integer heap[],int size)
   {  
      this.heap = heap; this.size = size ;
      for(int i=size/2;i>0;i--) // because from 1 to  n/2 number nodes are non leaf .
	  {
	     heapify(i,size);
		 
	  }		  
   }
   void heapify(int pos,int n)
   { 
	  	int largest = pos;		
		if(largest*2 <= n && heap[largest*2]>heap[largest]) largest = largest*2 ;
		if(largest+1 <= n && heap[largest+1] > heap[largest]) largest = largest+1;
		if(largest!=pos) 
		{
		   int a= heap[pos]; heap[pos] = heap[largest]; 
		   heap[largest] = a; 
		   heapify(largest,n);
		}
   }
   Integer[] sort()
   {	  
	  Integer sorted[]= new Integer[size+1];
	  for(int i=0;i<size;i++)
	  {
	     sorted[i+1]=heap[1]; // Bringing the MaxHeap into sorted list
         heap[1]=heap[size-i];		 
         heapify(1,size-i-1); // heapify the root data/ 		 
	  }
	  //System.out.println(Arrays.toString(sorted));
	  return sorted;
   }	   
}

/* 
10
5
7
4
15
3
8
9
10
2
1
*/
