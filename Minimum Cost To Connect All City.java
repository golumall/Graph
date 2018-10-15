import java.util.Scanner;
class ConnectCity
{
   int v;
   int g[][];
   	ConnectCity(int v)
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
   	int minKey(int a[],boolean memSet[])
   	{
   		int min=Integer.MAX_VALUE,index=0;
   		for(int i=0;i<v;i++)
   		{
   			if(memSet[i]==false&&a[i]<min)
   			{
   				min=a[i];
   				index=i;
   			}
   		}
   		return index;
   	}
   	void total(int parent[])
   	{
   		int tot=0;
   		for(int i=0;i<v;i++)
   		{
   			tot+=g[i][parent[i]];
   		}
   		System.out.println(tot);
   	}
   	void mst()
   	{
   		int key[]=new int[v];
   		int parent[]=new int[v];
   		boolean memSet[]=new boolean[v];
   		for(int i=0;i<v;i++)
   		{
   			memSet[i]=false;
   			key[i]=Integer.MAX_VALUE;
   		}
   		key[0]=0;
   		parent[0]=0;
   		for(int i=0;i<v;i++)
   		{
   			int u=minKey(key,memSet);
   			memSet[u]=true;
   			for(int j=0;j<v;j++)
   			{
   				if(g[u][j]!=0&&g[u][j]<key[j]&&memSet[j]==false)
   				{
   					key[j]=g[u][j];
   					parent[j]=u;

   				}
   			}
   		}
   		total(parent);
   	}
   	public static void main(String[] args) {
   		Scanner sc=new Scanner(System.in);
   		int v=sc.nextInt();
   		int e=sc.nextInt();
   		ConnectCity graph=new ConnectCity(v);
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
