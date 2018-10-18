import java.util.Scanner;
class Min_Edge_Reverse_Path_Source_To_Dest
{
	int v;
	int g[][];
	Min_Edge_Reverse_Path_Source_To_Dest(int v)
	{
		this.v=v;
		g=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				g[i][j]=-1;
			}
		}
	}
	void addEdge(int src,int dest)
	{
		g[src][dest]=0;
	}
   int minKey(int dist[],boolean memSet[])
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
   void shortPath(int src,int dest)
   {
   	for(int i=0;i<v;i++)
   	{
   		for(int j=0;j<v;j++)
   		{
   			if(g[i][j]==0)
   				g[j][i]=1;
   		}
   	}
   	int dist[]=new int[v];
   	boolean memSet[]=new boolean[v];
   	for(int i=0;i<v;i++)
   	{
       dist[i]=Integer.MAX_VALUE;
       memSet[i]=false;
   	}
     dist[0]=0;
     for(int i=0;i<v;i++)
     {
     	int u=minKey(dist,memSet);
     	memSet[u]=true;
     	for(int j=0;j<v;j++)
     	{
     		if(memSet[j]==false&&g[u][j]!=-1&&g[u][j]+dist[u]<dist[j]&&dist[u]!=Integer.MAX_VALUE)
     			dist[j]=g[u][j]+dist[u];
     	}
     }
     System.out.println("Minimum Edge Reverse Source "+src+" To "+dest+"\n"+dist[dest]);
   }
   public static void main(String[] args) {
   	Scanner sc=new Scanner(System.in);
   	int v=sc.nextInt();
   	int e=sc.nextInt();
   	Min_Edge_Reverse_Path_Source_To_Dest graph=new Min_Edge_Reverse_Path_Source_To_Dest(v);
   	for(int i=1;i<=e;i++)
   	{
   		int src=sc.nextInt();
   		int dest=sc.nextInt();
   		graph.addEdge(src,dest);
   	}
   	int src=sc.nextInt();
   		int dest=sc.nextInt();
   		graph.shortPath(src,dest);
   }
}
