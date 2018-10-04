

//Source
//https://www.geeksforgeeks.org/detecting-negative-cycle-using-floyd-warshall/
//https://www.youtube.com/watch?v=LwJdNfdLF9s


import java.util.Scanner;
class Floyd_Warshall_Algorithm
{
	int v;
	int g[][];
	static final int INF=1000000;
	Floyd_Warshall_Algorithm(int v)
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
	boolean detectCycle()
	{
		int i,j,k;
		int dist[][]=new int[v][v];
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
			{
				dist[i][j]=g[i][j];
			}
		}
		for(k=0;k<v;k++)
		{
			for(i=0;i<v;i++)
			{
				for(j=0;j<v;j++)
				{
                   if(dist[i][k]+dist[k][j]<dist[i][j])
                   	dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
		for(i=0;i<v;i++)
		{
			if(dist[i][i]<0)
				return true;
		}
		return false;

	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Floyd_Warshall_Algorithm gf=new Floyd_Warshall_Algorithm(v);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		int weight=sc.nextInt();
		gf.addEdge(src,dest,weight);
	}
	if(gf.detectCycle())
		System.out.println("YES");
	else
		System.out.println("NO");
}

}
