import java.util.Scanner;
import java.util.LinkedList;
class WeightedUndirectedGraph
{
	static class Edge
	{
		int source;
		//int dest;
		int weight;
		public Edge(int source,int weight)
		{
			this.source=source;
			//this.dest=dest;
			this.weight=weight;
		}
	}
	int v;
	LinkedList<Edge> adj[];
	WeightedUndirectedGraph(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
          adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int source,int dest,int weight)
	{
		Edge ob=new Edge(dest,weight);
		Edge ob1=new Edge(source,weight);
		adj[source].add(ob);
		adj[dest].add(ob1);
	}
	void printGraph()
	{
		int i=0;
		for(i=0;i<v;i++)
		{
			System.out.print(i);
			for(Edge ob:adj[i])
			{
				System.out.print("->"+ob.source+"-> Weight "+ob.weight);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		WeightedUndirectedGraph g=new WeightedUndirectedGraph(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			g.addEdge(src,dest,weight);
		}
		g.printGraph();
	}
}
