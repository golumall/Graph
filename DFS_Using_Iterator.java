import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
class DfsUsingItertator
{
  int v;
  LinkedList<Integer> adj[];
 public DfsUsingItertator(int v)
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
 void dfs(int s)
 {
 	int []visited=new int[v];
 	Stack<Integer> st=new Stack<Integer>();
 	st.push(s);
 	while(!st.isEmpty())
 	{
 		s=st.pop();
 		if(visited[s]==0)
 		{
 			System.out.print(s+" ");
 			visited[s]=1;
 		}
 		for(int i:adj[s])
 		{
 			if(visited[i]==0)
 				st.push(i);
 		}
 	}
 }
 public static void main(String ar[])
 {
 	Scanner sc=new Scanner(System.in);
 	int v=sc.nextInt();
 	int e=sc.nextInt();
 DfsUsingItertator graph=new DfsUsingItertator(v);
 for(int i=1;i<=e;i++)
 {
 	int src=sc.nextInt();
 	int dest=sc.nextInt();
 	graph.addEdge(src,dest);
 }	
 int s=sc.nextInt();
 graph.dfs(s);
 }

}
