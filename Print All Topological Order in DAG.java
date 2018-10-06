import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
class TopoLogical_Sort_Print_All
{
	int v;
	ArrayList<Integer> adj[];
   TopoLogical_Sort_Print_All(int v)
   {
   	this.v=v;
   	adj=new ArrayList[v];
   	for(int i=0;i<v;i++)
   	{
   		adj[i]=new ArrayList<>();
   	}

   }
   void addEdge(int src,int dest)
   {
   	adj[src].add(dest);
   }
   void topoSortUtil(boolean visited[],int inDegree[],ArrayList<Integer> stack)
   {
   	boolean flag=false;
   	for(int i=0;i<v;i++)
   	{
   		if(!visited[i]&&inDegree[i]==0)
   		{
   			visited[i]=true;
   			stack.add(i);
   			for(Integer j:adj[i])
   			{
   				inDegree[j]--;
   			}
   			topoSortUtil(visited,inDegree,stack);
   			visited[i]=false;
   			stack.remove(stack.size()-1);
   			for(Integer j:adj[i])
   			{
   				inDegree[j]++;
   			}
   			flag=true;
   		}
   	}

   	if(!flag)
   	{
   		stack.forEach(i->System.out.print(i+" "));
   		System.out.println();
   	}

   }
   void topoSort()
   {
   	boolean visited[]=new boolean[v];
   	int inDegree[]=new int[v];
   	for(int i=0;i<v;i++)
   	{
   		visited[i]=false;
   		inDegree[i]=0;
   	}
   	for(int i=0;i<v;i++)
   	{
   		for(Integer j:adj[i])
   		{
   			inDegree[j]++;
   		}
   	}
   	ArrayList<Integer> stack=new ArrayList<>();
   	topoSortUtil(visited,inDegree,stack);
   }
   public static void main(String[] args) {
   	Scanner sc=new Scanner(System.in);
   	int v=sc.nextInt();
   	int e=sc.nextInt();
   	TopoLogical_Sort_Print_All g=new TopoLogical_Sort_Print_All(v);
   	for(int i=1;i<=e;i++)
   	{
   		int src=sc.nextInt();
   		int dest=sc.nextInt();
   		g.addEdge(src,dest);
   	}
   	g.topoSort();
   }
  	
}
