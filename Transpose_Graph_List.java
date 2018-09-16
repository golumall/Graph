import java.util.LinkedList;
import java.util.Scanner;
class Transpose_Graph_LinkedList
{
	int v;
	LinkedList<Integer> adj[];
	LinkedList<Integer> b[];
  Transpose_Graph_LinkedList(int v)
  {
    this.v=v;
    adj=new LinkedList[v];
    b=new LinkedList[v];
    for(int i=0;i<v;i++)
    {
    	adj[i]=new LinkedList<>();
    		b[i]=new LinkedList<>();
    }
  }
  void addEdge(int src,int dest)
  {
  	adj[src].add(dest);
  }	
  void addEdge1(int src,int dest)
  {
         b[src].add(dest);
  }
  void transpose()
  {
  	
  	for(int i=0;i<v;i++)
  	{
  		for(Integer j:adj[i])
  		{
           addEdge1(i,j);
  		}
  	}
  	for(int i=0;i<v;i++)
  	{
  		System.out.print(i);
  		for(Integer j:b[i])
  		{
           System.out.print("->"+j);
  		}
  		System.out.println();
  	}

  }
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
Transpose_Graph_LinkedList g=new Transpose_Graph_LinkedList(v);
for(int i=1;i<=e;i++)
{
	int src=sc.nextInt();
	int dest=sc.nextInt();
	g.addEdge(src,dest);
}
g.transpose();
}
}
