
//Source
//https://www.geeksforgeeks.org/topological-sorting/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
class Topological_Sorting
{
int v;
LinkedList<Integer> adj[];
Stack<Integer> st=new Stack<>();
Topological_Sorting(int v)
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
void topoSortUtil(int v,boolean visited[])
{
	visited[v]=true;
	for(Integer i:adj[v])
	{
		if(!visited[i])
			topoSortUtil(i,visited);
	}
	st.push(v);
}
	void topoSort()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
				topoSortUtil(i,visited);
		}
		while(!st.isEmpty())
	     {
            System.out.print(st.pop()+" ");
	     }
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//System.out.println("Hi");
		int v=sc.nextInt();
		int e=sc.nextInt();
		//System.out.println("Hello");
		Topological_Sorting g=new Topological_Sorting(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.topoSort();
	}
	
}
