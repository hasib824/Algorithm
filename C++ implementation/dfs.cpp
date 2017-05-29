#include<bits/stdc++.h>
using namespace std;

int V,E,maxdist,agent;
int graph[100][100];
int dist[100];
int color[100];
int parent[100];



void dfsVisit(int agent)
{
      int v = agent ; // v is parent
       // distance of child
      for(int i=0;i<=V;i++)
      {
          if(graph[v][i]==1)
          {   int dis = dist[v]+1;
              int u = i; // here u is child
              if(color[u]==0 || dis<dist[u])
              {
                  color[u] = 1 ;
                  dist[u] = dis ;
                  if(maxdist<dist[u])
                  {
                      maxdist = dist[u] ;

                  }
                  parent[u] = v ;
                  dfsVisit(u);
              }
          }
      }
}

void dfs()
{
    for(int i=0;i<=V;i++)
    {
       dist[i]= 99999;
       color[i] = 0;
       parent[i] = -1 ;
    }

    color[agent] = 1;
    dist[agent] = 0;
    dfsVisit(agent);



}

void printDistance()
{
    for(int i=0;i<=maxdist; i++)
    {    printf("Distance %d nodes are : ",i);
        for(int j=0;j<=V;j++)
        {
           if(dist[j]==i)
           {
               printf("%d ",j);
           }
        }
        printf("\n");
    }
}


int main()
{
    while(1)
    {

        printf("Please enter the number Verteces : \n");
        scanf("%d",&V);
        printf("Please enter the number of Edges : \n");
        scanf("%d",&E);
        for(int i=0; i<E; i++)
        {
            int V1,V2;
            printf("Enter The connections : ");
            scanf("%d %d",&V1,&V2);
            graph[V1][V2]=1;
            graph[V2][V1]=1;

        }
        printf("Please enter the Agent : ");
        scanf("%d",&agent);
        dfs();
         printDistance();

    }
    return 0;
}

/*
4
6
1 2
1 3
2 3
4 1
3 4
4 2

*/
