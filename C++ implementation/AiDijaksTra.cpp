#include<bits/stdc++.h>
using namespace std;

struct compare{
  bool operator()(pair<int,int> &a, pair<int,int> &b)
  {
      return a.second>b.second;
  }
};


void printPath(int parent[], int i)
{

	if (parent[i]==-1)
		return;

	printPath(parent, parent[i]);
	printf("%d, ", i);
}

pair<int, int> in;
void printGp(map<int,vector<pair<int, int> > > graph)
{
   map<int, vector<pair<int, int> > > :: iterator it;
   for(it=graph.begin();it!=graph.end();it++)
   {
       int a=it->first;
       cout<<"Connection of "<<a<<" are : ";
       for(int i=0;i<graph[a].size();i++)
       {
         cout<<a<<" --> "<<graph[a][i].first<<" Weight : "<<graph[a][i].second<<" , ";
       }

       cout<<endl;
   }
}

void dijastr(map<int,vector<pair<int, int> > > graph, map<int,int> &d,priority_queue<pair<int,int>,vector< pair<int,int> >, compare> pQ,int s,int n,int parent[])
{
   map<int,vector<pair<int,int> > >:: iterator it;
   for(it=graph.begin();it!=graph.end();it++)
   {
      int u=it->first;
      d[u]=999999;
      parent[u] = -1;
   }
   d[s]=0; in.first=s;in.second=0;
   pQ.push(in);
   while(!pQ.empty())
   {
        int u=pQ.top().first;
        pQ.pop();
        for(int i=0;i<graph[u].size();i++)
        {   int v=graph[u][i].first;
            if(d[v]>d[u]+graph[u][i].second)
            {
               d[v]=d[u]+graph[u][i].second;
               parent[v] = u ;
               in.first=v; in.second=d[v];
               pQ.push(in);

            }
        }
   }
}
int main()
{
    while(1)
    {
        map<int,vector<pair<int, int> > > graph;
         priority_queue<pair<int,int>,vector< pair<int,int> >, compare> pQ;
         map<int,int> d; map<int,int> p;  map<int,int> c;
        cout<<"How many Nodes : ?"<<endl;
        vector<int> pd;
        int n; cin>>n; int parent[n];
        cout<<"How many Edges"<<endl;
        int e; cin>>e;
        for(int i=1;i<=e;i++)
        {
            cout<<"Please Enter the Connection : "<<endl;
            int w1,w2;
            cin>>w1>>w2;
            int weight; cout<<"Enter weight : "; cin>>weight;
            pair<int ,int > g; g.first=w2; g.second=weight;
            graph[w1].push_back(g); //g.first=w1;  graph[w2].push_back(g);
            cout<<endl;

        }
      // printGp(graph);
       cout<<"Please Enter the Source : "; int s; cin>>s;
       dijastr(graph,d,pQ,s,n,parent);
       map<int ,int >:: iterator path;
       int j=0;
       for(path=d.begin();path!=d.end();path++)
       {
         cout<<"\n"<<s<<" to "<<path->first<<" distance is : "<<path->second<<endl;
          printf("path : ");
          int i= path->first;
          printPath(parent, i); printf("\n");
         /*
          while(i!=-1)
            {
                printf("%d, ",i);
                i= parent[i];
            }
            */


       }
      cout<<endl;
    }
    return 0;
}

/*
4
6
1 2
10
1 3
5
2 3
3
3 2
4
3 4
1
4 2
2
*/
