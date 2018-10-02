
//Source
//https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

import java.util.LinkedList;
import java.util.Scanner;
class Detect_Loop
{
	int v;
	LinkedList<Integer> adj[];
	Detect_Loop(int v)
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
		adj[dest].add(src);
	}
	boolean isCycleUtil(int u,boolean visited[],int x)
	{
		visited[u]=true;
		for(Integer i:adj[u])
		{
			if(!visited[i])
				if(isCycleUtil(i,visited,u))
					return true;
            else if(i!=x)
              return true;		
		}
		return false;
	}
	boolean isCycle()
	{
		boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
        	if(!visited[i])
        		if(isCycleUtil(i,visited,-1))
        			return true;
        }
        return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Detect_Loop g=new Detect_Loop(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		if(g.isCycle())
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
