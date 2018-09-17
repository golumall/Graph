import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Height_Ternary_Tree
{
   int v,root;
   LinkedList<Integer> adj[];
   Height_Ternary_Tree(int v)
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
   int height()
   {
   	boolean []visited=new boolean[v];
   	Queue<Integer> q=new LinkedList<>();
   	q.add(root);
   	visited[root]=true;
   	int k=0;
   	while(!q.isEmpty())
   	{
   		
   		Queue<Integer> temp=new LinkedList<>();
   		while(!q.isEmpty())
   		{
            int u=q.poll();
   			for(Integer i:adj[u])
   			{
   				if(!visited[i])
   				{
   					temp.add(i);
   					visited[i]=true;
   				}

   			}
   		}
   		q=temp;
   		k++;
   	}
   	return (k-1);
   }
 public static void main(String[] args) {
 	Scanner sc=new Scanner(System.in);
 	int n=sc.nextInt();
 	int []a=new int[n];
   Height_Ternary_Tree graph=new Height_Ternary_Tree(n);
   	
 	for(int i=0;i<n;i++)
 	{
 		a[i]=sc.nextInt();
 		if(a[i]==-1)
 		{
 			graph.root=i;
 			continue;
 		}
 		graph.addEdge(a[i],i);
 	}
 	System.out.println(graph.height());

 }
	
}
