import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
class Kahns_Algo_TopoLogical_Sort
{
int v;
LinkedList<Integer> adj[];
Kahns_Algo_TopoLogical_Sort(int v)
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
void topoSort()
{
	int inDegree[]=new int[v];
	Queue<Integer> q=new LinkedList<>();
	for(int i=0;i<v;i++)
	{
		inDegree[i]=0;
	}
	for(int i=0;i<v;i++)
	{
		for(Integer j:adj[i])
		{
			inDegree[j]++;
		}
		
	}
	for(int i=0;i<v;i++)
	{
		if(inDegree[i]==0)
			q.add(i);
	}
	Vector<Integer> output=new Vector<>();
	int ct=0;
	while(!q.isEmpty())
	{
       int u=q.poll();
       output.add(u);
       for(Integer i:adj[u])
       {
       	  if(--inDegree[i]==0)
       	  	q.add(i);
       }
     ct++;
	}
	if(ct!=v)
		System.out.println("Graph is not DAG");
	else
	{
		for(Integer i:output)
			System.out.print(i+" ");
	}
	

}	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Kahns_Algo_TopoLogical_Sort g=new Kahns_Algo_TopoLogical_Sort(v);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		g.addEdge(src,dest);
	}
	g.topoSort();
}
}
