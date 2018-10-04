

//Source
//https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
//https://www.youtube.com/watch?v=-mOEd_3gTK0&t=324s

import java.util.Scanner;
import java.util.LinkedList;
class Bell_Man_Ford_Algo
{
	static class Edge
	{
		int src;
		int dest;
		int weight;
		public Edge(int src,int dest,int weight)
		{
			this.src=src;
			this.dest=dest;
			this.weight=weight;
        }
	}
	int v;
	LinkedList<Edge> adj[];
	Bell_Man_Ford_Algo(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest,int weight)
	{
		Edge ob=new Edge(src,dest,weight);
		adj[src].add(ob);
	}
	void bellman(int src)
	{
		int dist[]=new int[v];
		int i,j;
		for(i=0;i<v;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[src]=0;
        for(i=1;i<=v-1;i++)
        {
             for(i=0;i<v;i++)
             {
             	for(Edge k:adj[i])
             	{
             		if(dist[k.dest]>dist[i]+k.weight&&dist[i]!=Integer.MAX_VALUE)
             			dist[k.dest]=dist[i]+k.weight;
             	}
             }
        }
         for(i=0;i<v;i++)
         {
         	System.out.println("Shortest Path from "+src+" To "+i+"="+dist[i]);
         }
         
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Bell_Man_Ford_Algo g=new Bell_Man_Ford_Algo(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			g.addEdge(src,dest,weight);
		}
		//Source which we want to find minimum distance for all vertices
		int src=sc.nextInt();
		g.bellman(src);
	}
	
}
