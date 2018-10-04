//Source

//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/

import java.util.LinkedList;
import java.util.Scanner;
class Detect_Cycle_Undirected_Graph
{
   int v;
   LinkedList<Integer> adj[];
   Detect_Cycle_Undirected_Graph(int v)
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
   boolean isCycleUtil(int u,boolean visited[],boolean recursion[])
   {
   	visited[u]=true;
   	recursion[u]=true;
   	for(Integer i:adj[u])
   	{
   		if(!visited[i]&&isCycleUtil(i,visited,recursion))
   			return true;
   		else if(recursion[i])
   			return true;

   	}
   	recursion[u]=false;
   	return false;
   }
   boolean isCycle()
   {
   	boolean visited[]=new boolean[v];
   	boolean recursion[]=new boolean[v];
   	for(int i=0;i<v;i++)
   	{
   		if(!visited[i])
   			if(isCycleUtil(i,visited,recursion))
   				return true;
   	}
   	return false;
   }
   public static void main(String[] args) {
   		Scanner sc=new Scanner(System.in);
   		int v=sc.nextInt();
   		int e=sc.nextInt();
   		Detect_Cycle_Undirected_Graph g=new Detect_Cycle_Undirected_Graph(v);
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
