import java.util.Scanner;
import java.util.LinkedList;
class WeightedGraph
{
	static class Edge
	{
		int src;
		int dest;
		int weight;
		Edge(int src,int dest,int weight)
		{
			this.src=src;
			this.weight=weight;
			this.dest=dest;
		}
	}
	int v;
	LinkedList<Edge> adj[];
  WeightedGraph(int v)
  {
  	this.v=v;
  	adj=new LinkedList[v];
  	for(int i=0;i<v;i++)
  	{
  		adj[i]=new LinkedList<Edge>();
  	}
  }
  void addEdge(int src,int dest,int weight)
  {
     Edge e=new Edge(src,dest,weight);
     adj[src].add(e);//In case of Directed Graph
     

  }	
  void printGraph()
  {
  	int i;
  	for(i=0;i<v;i++)
  	{
  		for(Edge j:adj[i])
  		{
  			System.out.println("Source="+i+" Destination="+j.dest+" Weight="+j.weight);
  		}
  	}
  }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
        WeightedGraph g=new WeightedGraph(v);
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
