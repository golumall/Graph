import java.util.Scanner;
import java.util.LinkedList;
class Vertex_Cover
{
	int v;
	LinkedList<Integer> adj[];
	Vertex_Cover(int v)
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
	void cover()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				for(Integer j:adj[i])
				{
					if(visited[j]==false)
					{
						visited[j]=true;
						visited[i]=true;
						break;
					}
				}
			}
		}

		for(int i=0;i<v;i++)
		{
			if(visited[i])
				System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Vertex_Cover g=new Vertex_Cover(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.cover();
	}

}
