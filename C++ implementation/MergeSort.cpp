#include<stdio.h>
using namespace std;
void merger(int A[],int left[],int leftSize,int right[],int rightSize)
{   // printf("\nIs it breaks \n");
     int i=0;int j=0; int k=0;
     while(((i<leftSize)&&(j<rightSize)))
     {
         if(left[i]>=right[j]) A[k++] = left[i++];
         else A[k++] = right[j++];
     }
     while(i<leftSize) A[k++] = left[i++];
     while(j<rightSize) A[k++] = right[j++];

     /*printf("\nAfter marge : ");
     for(int i=0; i<(leftSize+rightSize); i++)
     {
         printf("%d, ",A[i]);
     }*/
}

void MySort(int A[],int n)
{    if(n<2) return;
    // printf("\n\nSize is %d : ",n);
     int mid = n/2;
     int left[mid+1]; int right[n-mid];
    // printf("\nLeft : ");
     for(int i=0;i<mid;i++)
     {
         left[i] = A[i]; //printf("%d ,",left[i]);
     }
    // printf("\nRight : ");
     for(int i=mid, j=0; i<n;i++)
     {
         right[j]=A[i]; //printf("%d, ",right[j]);
         j++;
     }
     MySort(left,mid);
     MySort(right,n-mid);
     merger(A,left,mid,right,n-mid);
}
int main()
{
    int n;
    printf("How many Numbers : ");
    scanf("%d",&n); int A[n];
    printf("Total datas are : %d",n);
    printf("Please enter the numbers : ");
    for(int i=0;i<n;i++)
    {
       scanf("%d",&A[i]);
    }
    MySort(A,n);
    printf("\nThe sorted datas are : ");
    for(int i=0;i<n;i++)
    {
       printf("%d, ",A[i]);
    }
    return 0;
}


/*
10
17
8
14
21
4
6
12
7
3
11
*/
