import java.util.Scanner;
class Number_Of_Triangle
{
	int v;
	int g[][];
	Number_Of_Triangle(int v)
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
		g[dest][src]=1;
	}
	int triangle()
	{
		int res[][]=new int[v][v];
		int tmp[][]=new int[v][v];
		int i,j,k;
		
    //Find G^2
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
			{
				res[i][j]=0;
				for(k=0;k<v;k++)
				{
					res[i][j]+=g[i][k]*g[k][j];
				}
			}
		}
   //Find G^3
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
			{
				tmp[i][j]=0;
				for(k=0;k<v;k++)
				{
					tmp[i][j]+=res[i][k]*g[k][j];
				}
			}
		}
		j=0;
		for(i=0;i<v;i++)
		{
			j+=tmp[i][i];
		}
     return (j/6);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Number_Of_Triangle gr=new Number_Of_Triangle(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			gr.addEdge(src,dest);
		}
		System.out.println("Number of Triangle="+gr.triangle());
	}
}
