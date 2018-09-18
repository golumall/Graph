import java.util.Scanner;
import java.util.ArrayList;
class Print_All_Path
{
	int v;
	ArrayList<Integer> []adj;
	Print_All_Path(int v)
	{
		this.v=v;
		adj=new ArrayList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new ArrayList<Integer>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
	}
	void printPath(int src,int dest)
	{
		boolean []visited=new boolean[v];
		ArrayList<Integer> path=new ArrayList<Integer>();
		path.add(src);
		printAllPath(src,dest,visited,path);
	}
	void printAllPath(int src,int dest,boolean visited[],ArrayList<Integer> path)
	{
		visited[src]=true;
		if(src==dest)
			System.out.println(path);
		for(Integer i:adj[src])
		{
			if(!visited[i])
			{
				path.add(i);
				printAllPath(i,dest,visited,path);
				path.remove(i);
			}
		}
		visited[src]=false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Print_All_Path g=new Print_All_Path(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
			int src=sc.nextInt();
			int dest=sc.nextInt();
		
		g.printPath(src,dest);
	}
	
}
