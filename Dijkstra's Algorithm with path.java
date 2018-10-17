import java.util.Scanner;
import java.util.Stack;
class Dijkstra_Algorithm
{
	int v;
	int g[][];
	Dijkstra_Algorithm(int v)
	{
		this.v=v;
		g=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				g[i][j]=0;
			}
		}
	}
	void addEdge(int src,int dest,int weight)
	{
		g[src][dest]=weight;
		g[dest][src]=weight;
	}
	int minDist(int dist[],boolean memSet[])
	{
		int min=Integer.MAX_VALUE,minIndex=0;
		for(int i=0;i<v;i++)
		{
			if(memSet[i]==false&&dist[i]<min)
			{
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	void dijkstra(int src)
	{
		int dist[]=new int[v];
		boolean memSet[]=new boolean[v];
		int parent[]=new int[v];
		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			memSet[i]=false;
		}
		dist[src]=0;
		parent[src]=-1;
		for(int i=0;i<v;i++)
		{
			int u=minDist(dist,memSet);
			memSet[u]=true;
			for(int j=0;j<v;j++)
			{
				if(memSet[j]==false&&g[u][j]!=0&&g[u][j]+dist[u]<dist[j]&&dist[u]!=Integer.MAX_VALUE)
				{
					dist[j]=g[u][j]+dist[u];
					parent[j]=u;
				}
			}
		}
	for(int i=0;i<v;i++)
	{
		System.out.println(i+"-->"+dist[i]);
	}
	path(parent);
	}
	void path(int parent[])
	{
		Scanner sc=new Scanner(System.in);
		Stack<Integer> st=new Stack<>();
		int d=sc.nextInt();
		st.push(d);
		while(parent[d]!=-1)
		{
			int u=parent[d];
			st.push(parent[d]);
			d=u;
		}
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+"-->");

		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Dijkstra_Algorithm graph=new Dijkstra_Algorithm(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph.addEdge(src,dest,weight);
		}
		int src=sc.nextInt();//Source Vertex.
		graph.dijkstra(src);
		
	}
}
