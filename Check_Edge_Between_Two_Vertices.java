import java.util.LinkedList;
import java.util.Scanner;
class Find_Edge
{
   int v;
   LinkedList<Integer> adj[];
  Find_Edge(int v)
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
  boolean check(int a,int b)
  {
  	for(Integer i:adj[a])
  	{
  		if(i==b)
  			return true;
  	}
  	return false;
  }
  public static void main(String ar[])
  {
  	Scanner sc=new Scanner(System.in);
  	int v=sc.nextInt();
  	int e=sc.nextInt();
  	Find_Edge graph=new Find_Edge(v);
  	for(int i=1;i<=e;i++)
  	{
  		int src=sc.nextInt();
  		int dest=sc.nextInt();
  		graph.addEdge(src,dest);
  	}
    //Vertices which you want to check edge
  int a=sc.nextInt();
  int b=sc.nextInt();
  if(graph.check(a,b))
  	System.out.println("Found");
  else
    System.out.println("Not Found");

  }
}
