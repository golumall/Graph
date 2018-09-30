
//Sources
//https://www.geeksforgeeks.org/sum-of-the-minimum-elements-in-all-connected-components-of-an-undirected-graph/

import java.util.LinkedList;
import java.util.Scanner;
class Sum_Of_Minimum_Connected_Component
{
	int v;
	LinkedList<Integer> adj[];
	 boolean []visited;
	Sum_Of_Minimum_Connected_Component(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		visited=new boolean[v];
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
	void dfsUtil(int node,int a[],int m)
	{
		m=Math.min(m,a[node]);
		visited[node]=true;
		for(Integer i:adj[node])
		{
			if(!visited[i])
				dfsUtil(i,a,m);
		}
	}
	void dfs(int []a)
	{
       int sum=0;
       for(int i=0;i<v;i++)
       {
       	if(!visited[i])
       	{
       		int m=a[i];
       		dfsUtil(i,a,m);
       		sum+=m;

       	}
       }
       System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int []a=new int[v];
		for(int i=0;i<v;i++)
			a[i]=sc.nextInt();
		int e=sc.nextInt();
		Sum_Of_Minimum_Connected_Component g=new Sum_Of_Minimum_Connected_Component(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
             g.addEdge(src,dest);
		}
		g.dfs(a);
	}

}
