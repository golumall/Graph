import java.util.Scanner;
import java.util.Arrays;
class Travelling_SalesMan_Problem
{
int v;
static int g[][];
static int visited[];
static int x,y,dstX,fans=Integer.MAX_VALUE;
Travelling_SalesMan_Problem(int v)
{
	this.v=v;
	g=new int[v][v];
	visited=new int[v];
	Arrays.fill(visited,0);


}
void tsp(int x,int y,int ans,int check)
{
	if(check==v)
	{
		int tans=ans+g[x][dstX];
		fans=Math.min(fans,tans);
	}
	for(int i=0;i<v;i++)
	{
		if(visited[i]==0)
		{
			if(x!=i)
			{
				visited[i]=1;
				int cost=ans+g[x][i];
				tsp(i,0,cost,check+1);
				visited[i]=0;
			}
		}
	}

}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();

	Travelling_SalesMan_Problem gr=new Travelling_SalesMan_Problem(v);
	for(int i=0;i<v;i++)
	{
		for(int j=0;j<v;j++)
		{
			g[i][j]=sc.nextInt();
		}
	}
	x=y=dstX=0;

	gr.tsp(0,0,0,0);
	System.out.println(fans);

}
	
}
