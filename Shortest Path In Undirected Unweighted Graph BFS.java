
//Time Complexity O(v+e)
//Space Complexity O(v)

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Shortest_Path_Bfs
{
	int v;
	LinkedList<Integer> adj[];
	Shortest_Path_Bfs(int v)
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
	void shortPath(int src,int dest)
	{
		boolean visited[]=new boolean[v];
		int path[]=new int[v];
		int minPath[]=new int[v];
		for(int i=0;i<v;i++)
		{
			path[i]=0;
			minPath[i]=0;
			visited[i]=false;
		}
		Queue<Integer> q=new LinkedList<>();
		
		q.add(src);
		visited[src]=true;
		path[src]=-1;
		
		while(!q.isEmpty())
		{
			int u=q.poll();
			for(Integer i:adj[u])
			{
				if(!visited[i])
				{
					visited[i]=true;
					q.add(i);
					minPath[i]=minPath[u]+1;
					path[i]=u;
					if(i==dest)
					{
					   
                          printPath(path,minPath,src,dest);
						return;
					}
				}
			}
		}
	}
	void printPath(int path[],int minPath[],int src,int dest)
	{
		Stack<Integer> st=new Stack<>();
		st.push(dest);
		System.out.println("Shortest Distance="+minPath[dest]);
		while(path[dest]!=-1)
		{
			int u=path[dest];
			st.push(u);
			dest=u;
		}
		System.out.println("Shortest Path");
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Shortest_Path_Bfs g=new Shortest_Path_Bfs(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		int src=sc.nextInt();
			int dest=sc.nextInt();
		g.shortPath(src,dest);
	}

	
}

