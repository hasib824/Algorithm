#include<stdio.h>
#include<vector>
#include<stack>

using namespace std;

int V,E,L,desti;
vector<int> Graph[100];
stack<int> st;

void insert_graph()
{
    int i,j;
    printf("Please enter the number Verteces : \n");
    scanf("%d",&V);
    printf("Please enter the number of Edges : \n");
    scanf("%d",&E);
    for(i=1; i<=E; i++)
    {
        int V1,V2;
        printf("Enter The connections : ");
        scanf("%d %d",&V1,&V2);
        Graph[V1].push_back(V2);
        Graph[V2].push_back(V1);
    }
}

void print_graph()
{
    int i,j;
    printf("\nthe connetions are : \n");
    for(i=1; i<=V; i++)
    {
        printf("Connections of %d ----> ",i);
        for(j=0; j<Graph[i].size(); j++) printf("%d , ",Graph[i][j]);
        printf("\n");
    }
}

bool visited[100];
int d[100];


void dfs(int source)
{
    int maxdist= L+10;
    for(int i=0; i<V; i++)
    {
        visited[i]=0; d[i]= maxdist;
    }
    d[source] = 0 ; visited[source] = 1;
    st.push(source);

    while(!st.empty())
    {
        int v = st.top();  st.pop();
        for(int i=0; i<Graph[v].size(); i++)
        {
            int u = Graph[v][i];
            if(d[u]>d[v]+1) visited[u] = 0; // if it is the shortest path to U
            if(visited[u]==0)
            {
                visited[u]=1; d[u]=d[v]+1;
                if(d[u]<L) st.push(u);
                if(u==desti && d[u]<=L)
                {
                    printf("\nResult : Destination found within range\n");
                    return ;
                }
            }
        }
    }
    printf("\nResult : Not found\n");
}


int main()
{
    while(1)
    {
        insert_graph();
        print_graph();
        printf("Please enter the source and destination  : ");
        int source;
        scanf("%d %d",&source, &desti);
        printf("Please enter the limit : ");
        scanf("%d",&L);
        dfs(source);
        return  0;
    }
}

/*
6
7
1 2
1 4
2 4
2 5
3 4
4 5
4 6

1 4
1

*/

/*

8
10
1 2
1 3
2 4
3 5
4 5
4 6
5 6
6 7
4 8
7 8

1 8
3


*/
