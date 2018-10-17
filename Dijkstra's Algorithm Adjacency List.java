import java.util.Scanner;
import java.util.LinkedList;
class Dijkstra_Adjacency_List
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
	Dijkstra_Adjacency_List(int v)
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
	int minKey(int key[],boolean memSet[])
	{
		int min=Integer.MAX_VALUE,minIndex=0;
		for(int i=0;i<v;i++)
		{
			if(memSet[i]==false&&key[i]<min)
			{
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	void dijks()
	{
		int key[]=new int[v];
		boolean memSet[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			key[i]=Integer.MAX_VALUE;
			memSet[i]=false;
		}
		key[0]=0;
		for(int i=0;i<v;i++)
		{
			int u=minKey(key,memSet);
			memSet[u]=true;
			for(Edge j:adj[u])
			{
				if(memSet[j.dest]==false&&j.weight+key[u]<key[j.dest]&&key[u]!=Integer.MAX_VALUE)
					key[j.dest]=j.weight+key[u];

			}
		}
		for(int i=0;i<v;i++)
		{
			System.out.println(i+"-->"+key[i]);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Dijkstra_Adjacency_List graph=new Dijkstra_Adjacency_List(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph.addEdge(src,dest,weight);
		}
		//
		graph.dijks();
		
	}

}
