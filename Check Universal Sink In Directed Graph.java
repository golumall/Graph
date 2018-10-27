import java.util.Scanner;
class Check_Universal_Shink
{
	int v;
	int g[][];
	Check_Universal_Shink(int v)
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
	void addEdge(int src,int dest)
	{
		g[src][dest]=1;
	}
	int check()
	{
		int x=0;
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(g[j][i]==1)
					x++;

			}
			if(x==5)
				return i;

		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Check_Universal_Shink graph=new Check_Universal_Shink(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			graph.addEdge(src,dest);
		}
		System.out.println(graph.check());
	}
}
