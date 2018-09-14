import java.util.LinkedList;
import java.util.Scanner;
class Count_Tree
{
   int v;
   LinkedList<Integer> adj[];
   Count_Tree(int v)
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
   void dfsUtil(int u,boolean visited[])
   {
      visited[u]=true;
      for(Integer i:adj[u])
      {
      	if(!visited[i])
      	{
             dfsUtil(i,visited);
      	}
      }
   }
   int countTree()
   {
   	int res=0;
   	boolean visited[]=new boolean[v];
   	for(int i=0;i<v;i++)
   	{
      if(!visited[i])
      {
      	dfsUtil(i,visited);
      	res++;
      }
   	}
   	return res;
   }	
   public static void main(String arg[])
   {
   	Scanner sc=new Scanner(System.in);
   	int v=sc.nextInt();
   	int e=sc.nextInt();
   	Count_Tree graph=new Count_Tree(v);
   	for(int i=1;i<=e;i++)
   	{
   		int src=sc.nextInt();
   		int dest=sc.nextInt();
   		graph.addEdge(src,dest);
   	}
   	System.out.println(graph.countTree());
   }
}
