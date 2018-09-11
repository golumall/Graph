import java.util.LinkedList;
import java.util.Scanner;
class Linked_List_Represent
{
	public static class Graph
	{
		int v;
		LinkedList<Integer> adjlist[];
		public Graph(int v)
		{
           this.v=v;
           adjlist=new LinkedList[v];
           for(int i=0;i<v;i++)
           {
           	adjlist[i]=new LinkedList<>();
           }
		}
	}
	static void addEdge(Graph graph,int src,int dest)
	{
		graph.adjlist[src].addFirst(dest);
		graph.adjlist[dest].addFirst(src);
	}
	static void printGraph(Graph graph)
	{
		for(int i=0;i<graph.v;i++)
		{
			for(Integer gp:graph.adjlist[i])
			{
				System.out.print("->"+gp);
			}
			System.out.println();
		}
	}
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Graph graph=new Graph(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			addEdge(graph,src,dest);
		}
		printGraph(graph);
	}
	
}
