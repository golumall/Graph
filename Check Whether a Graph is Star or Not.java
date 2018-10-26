import java.util.Scanner;
import java.util.LinkedList;
class Star_Graph
{
	int v;
	LinkedList<Integer> adj[];
	Star_Graph(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	boolean check()
	{
		for(int i=0;i<v;i++)
		{
			if(adj[i].size()!=1&&adj[i].size()!=(v-1))
			   return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Star_Graph g=new Star_Graph(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		if(g.check())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
