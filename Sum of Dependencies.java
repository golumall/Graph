

//Sources
//https://www.geeksforgeeks.org/sum-dependencies-graph/

import java.util.Scanner;
import java.util.LinkedList;
class Sum_Degree
{
	int v;
	LinkedList<Integer> adj[];
	Sum_Degree(int v)
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
	int sum()
	{
		int s=0;
		for(int i=0;i<v;i++)
		{
			s+=adj[i].size();
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Sum_Degree g=new Sum_Degree(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		System.out.println(g.sum());
	}

}
