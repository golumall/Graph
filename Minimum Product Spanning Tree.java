import java.util.Scanner;
class Min_Product_Spanning_Tree
{
	int v;
	int g[][];
	Min_Product_Spanning_Tree(int v)
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
	void totProductTree(int parent[])
	{
		int pro=1;
		for(int i=0;i<v;i++)
		{
			if(g[i][parent[i]]!=0)
			pro*=g[i][parent[i]];
		}
		System.out.println(pro);

	}
	void mst()
	{
		int parent[]=new int[v];
		int key[]=new int[v];
		boolean memSet[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			key[i]=Integer.MAX_VALUE;
			memSet[i]=false;
		}
		key[0]=0;
		parent[0]=0;
		for(int i=0;i<v;i++)
		{
			int u=minKey(key,memSet);
			memSet[u]=true;
			for(int j=0;j<v;j++)
			{
				if(g[u][j]!=0&&memSet[j]==false&&g[u][j]<key[j])
				{
					key[j]=g[u][j];
					parent[j]=u;
				}


			}
		}
		totProductTree(parent);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Min_Product_Spanning_Tree graph=new Min_Product_Spanning_Tree(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph.addEdge(src,dest,weight);
		}
		graph.mst();
	}
	
}
