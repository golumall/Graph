
//Sources
//https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/

import java.util.Scanner;
class Floyd_Warshall
{
int v;
int g[][];
static final int INF=100000;
Floyd_Warshall(int v)
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
void floyd()
{
	int sol[][]=new int[v][v];
	for(int i=0;i<v;i++)

	{
		for(int j=0;j<v;j++)
		{
			sol[i][j]=g[i][j];
		}
	}
	for(int k=0;k<v;k++)
	{
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(sol[i][k]+sol[k][j]<sol[i][j])
					sol[i][j]=sol[i][k]+sol[k][j];
			}
		}
	}
	for(int i=0;i<v;i++)

	{
		for(int j=0;j<v;j++)
		{
			if(sol[i][j]==INF)
	System.out.print("INF ");
	else			
	System.out.print(sol[i][j]+" ");
		}
		System.out.println();
	}

}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Floyd_Warshall fw=new Floyd_Warshall(v);
	for(int i=1;i<=v;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		int weight=sc.nextInt();
		fw.addEdge(src,dest,weight);
	}
fw.floyd();

}
	
}

//Time Complexity O(v^3)

//space complexity O(v^2)
//v is number of vertices in graph
