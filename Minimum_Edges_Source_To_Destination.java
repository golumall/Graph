import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
class Mimimum_Edges_Using_Queue
{
   int v;
 LinkedList<Integer> adj[];
 Mimimum_Edges_Using_Queue(int v)
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
 int minEdge(int src,int dest)
 {
 	boolean []visited=new boolean[v];
 	int []ad=new int[v];
   Queue<Integer> q=new LinkedList<>();
   q.add(src);
   ad[src]=0;
   visited[src]=true;
   while(!q.isEmpty())
   {
   	int u=q.poll();
   	for(Integer i:adj[u])
   	{
   		if(!visited[i])
   		{
           ad[i]=ad[u]+1;
           visited[i]=true;
           q.add(i);

   		}
   	}
   }
    sreturn ad[dest];
 }
 public static void main(String args[])
 {
 	Scanner sc=new Scanner(System.in);
 	int v=sc.nextInt();
 	int e=sc.nextInt();
Mimimum_Edges_Using_Queue g=new Mimimum_Edges_Using_Queue(v);
for(int i=1;i<=e;i++)
{
	int src=sc.nextInt();
	int dest=sc.nextInt();
	g.addEdge(src,dest);

 }
	int src=sc.nextInt();
	int dest=sc.nextInt();
System.out.println(g.minEdge(src,dest));
}
}
