import java.util.Scanner;
class Prims_Algorithm
{
	int v;
	int g[][];
	Prims_Algorithm(int v)
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
	int minValue(int key[],boolean mstSet[])
	{
		int min=Integer.MAX_VALUE,minIndex=0;
		for(int i=0;i<v;i++)
		{
			if(key[i]<min&&mstSet[i]==false)
			{
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	void printMst(int parent[])
	{
		int tot=0;
         for(int i=0;i<v;i++)
         {
         	tot+=g[i][parent[i]];
         	System.out.println(i+"->"+parent[i]+"  "+g[i][parent[i]]);
         }
         System.out.println("Total Weight "+tot);
	}
	void primMst()
	{
		int key[]=new int[v];
		int parent[]=new int[v];
		boolean mstSet[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			mstSet[i]=false;
			key[i]=Integer.MAX_VALUE;
			//parent[i]=0;
		}
		key[0]=0;
		parent[0]=0;
		for(int i=0;i<v;i++)
		{
			int u=minValue(key,mstSet);
			mstSet[u]=true;
			for(int j=0;j<v;j++)
			{
			    if(g[u][j]!=0&&g[u][j]<key[j]&&mstSet[j]==false)
			    {
			    	parent[j]=u;
			    	key[j]=g[u][j];
			    }
			}
		}
		printMst(parent);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Prims_Algorithm graph=new Prims_Algorithm(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph.addEdge(src,dest,weight);
		}
		graph.primMst();
	}
}
