import java.util.Scanner;
import java.util.LinkedList;
class Dfs
{
   int v;
   LinkedList<Integer> adj[];
   Dfs(int v)
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
   void dfsUtil(int s,boolean visited[])
   {
   	visited[s]=true;
   	System.out.print(s+" ");
   	for(Integer i:adj[s])
   	{
   		if(!visited[i])
   		{
   			dfsUtil(i,visited);
   		}
   	}
   }
   void mdfs(int s)
   {
   	boolean visited[]=new boolean[v];
   	dfsUtil(s,visited);
   }
   public static void main(String ar[])
   {
   	Scanner sc=new Scanner(System.in);
   	int v=sc.nextInt();
   	int e=sc.nextInt();
     Dfs d=new Dfs(v);
     for(int i=1;i<=e;i++)
     {
     	int src=sc.nextInt();
     	int dest=sc.nextInt();
     	d.addEdge(src,dest);
     }
     //Vertix where we want to start Dfs
     int s=sc.nextInt();
     d.mdfs(s);
   }
}
