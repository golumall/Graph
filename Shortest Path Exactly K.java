import java.util.Scanner;
class Shortest_Path_Exact_K
{
	int v;
	int g[][];
	static final int INF=100000;
	Shortest_Path_Exact_K(int v)
	{
		this.v=v;
		g=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i==j)
					g[i][j]=0;
				else
					g[i][j]=INF;
			}
		}
	}
	void addEdge(int src,int dest,int weight)
	{
		g[src][dest]=weight;
	}
	int path(int u,int v,int k)
	{
		if(k==0&&u==v)
			return 0;
		if(k==1&&g[u][v]!=INF)
			return g[u][v];
		if(k<=0)
			return INF;
		int res=INF;
		for(int i=0;i<v;i++)
		{
			if(g[u][i]!=INF&&u!=i&&v!=i)
			{
				int rec_res=path(i,v,k-1);
				if(g[u][i]!=INF)
					res=Math.min(res,g[u][i]+rec_res);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Shortest_Path_Exact_K graph=new Shortest_Path_Exact_K(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph.addEdge(src,dest,weight);
		}
		int src=sc.nextInt();
		int dest=sc.nextInt();
		int k=sc.nextInt();
		System.out.println(graph.path(src,dest,k));
	}
}
