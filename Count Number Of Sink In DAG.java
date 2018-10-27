import java.util.Scanner;
import java.util.LinkedList;
class Number_Of_SinkNode_DAG
{
	int v;
	LinkedList<Integer> adj[];
	Number_Of_SinkNode_DAG(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
	}
	int countSink()
	{
		int a[]=new int[v];
		int x=0;
		for(int i=0;i<v;i++)
		{
			a[i]=0;
		}
		for(int i=0;i<v;i++)
		{
			for(Integer j:adj[i])
			{
				a[i]=1;
			}
		}
		for(int i=0;i<v;i++)
			if(a[i]==0)
				x++;

	return x;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Number_Of_SinkNode_DAG g=new Number_Of_SinkNode_DAG(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		System.out.println(g.countSink());
	}
	
}
