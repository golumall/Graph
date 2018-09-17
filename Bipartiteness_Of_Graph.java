import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Bipartite
{
	int v;
	int [][]mat;
	Bipartite(int v)
	{
		this.v=v;
		mat=new int [v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				mat[i][j]=0;
			}
		}
	}
	void addEdge(int src,int dest)
	{
		mat[src][dest]=1;
		mat[dest][src]=1;
	}
	boolean checkPartite()
	{
		int i;
		int []visited=new int[v];
		for( i=0;i<v;i++)
			visited[i]=-1;
		Queue<Integer> q=new LinkedList<>();
		q.add(0);
		visited[0]=1;
		if(mat[0][0]==1)
			return false;
		while(!q.isEmpty())
		{
			int u=q.poll();
			for(i=0;i<v;i++)
			{
                 if(mat[u][i]==1&&visited[i]==-1)
                 {
                 	q.add(i);
                 	visited[i]=1-visited[u];
                 }
                 else if(mat[u][i]==1&&visited[u]==visited[i])
                 	return false;
			}
		}
		return true;

	}
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
     Bipartite g=new Bipartite(v);	
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
           g.addEdge(src,dest);
		}
		if(g.checkPartite())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
