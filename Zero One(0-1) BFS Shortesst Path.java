import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;
class Zero_One_Bfs_ShortestPath
{
	class Edge
	{
		int dest;
		int weight;
		Edge(int dest,int weight)
		{
			this.dest=dest;
			this.weight=weight;
		}
	}
	int v;
	LinkedList<Edge> adj[];
	Zero_One_Bfs_ShortestPath(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest,int weight)
	{
		Edge ob1=new Edge(dest,weight);
		Edge ob2=new Edge(src,weight);
		adj[src].add(ob1);
		adj[dest].add(ob2);
	}
	void path(int src)
	{
		int dist[]=new int[v];
		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		dist[src]=0;
		Deque<Integer> q=new LinkedList<>();
		q.addLast(src);
		while(!q.isEmpty())
		{
			int v=q.pollFirst();
			for(Edge i:adj[v])
			{
				if(dist[i.dest]>dist[v]+i.weight)
				{
					dist[i.dest]=dist[v]+i.weight;
					if(i.weight==0)
						q.addFirst(i.dest);
					else
						q.addLast(i.dest);

				}
			}
		}
		for(int i=0;i<v;i++)
		{
			System.out.print(dist[i]+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Zero_One_Bfs_ShortestPath g=new Zero_One_Bfs_ShortestPath(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			g.addEdge(src,dest,weight);
		}
		int src=sc.nextInt();
		g.path(src);
	}
	
}
