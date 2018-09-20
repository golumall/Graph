import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Bfs_In_Undirected_Graph
{
	int v;
	ArrayList<Integer> adj[];
  Bfs_In_Undirected_Graph(int v)
  {
  	this.v=v;
  	adj=new ArrayList[v];
  	for(int i=0;i<v;i++)
  	{
  		adj[i]=new ArrayList<Integer>();
  	}
  }
  void addEdge(int src,int dest)
  {
  	adj[src].add(dest);
  }
  void bfsUtil(int s,boolean []visited)
  {
  	Queue<Integer> q=new LinkedList<>();
  	q.add(s);
  	visited[s]=true;
  	while(!q.isEmpty())
  	{
  		int u=q.poll();
  		
  		System.out.print(u+" ");
  		for(Integer i:adj[u])
  		{
  			if(!visited[i])
  			{
              q.add(i);
              visited[i]=true;
  			}
  		}

  	}
  }
  void bfs()
  {
  	boolean visited[]=new boolean[v];
  	int i;
  	for(i=0;i<v;i++)
  	{
  		if(!visited[i])
  			bfsUtil(i,visited);
  	}
  }
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
Bfs_In_Undirected_Graph g=new Bfs_In_Undirected_Graph(v);
for(int i=1;i<=e;i++)
{
   int src=sc.nextInt();
   int dest=sc.nextInt();
   g.addEdge(src,dest);	
}
g.bfs();	
}
}
