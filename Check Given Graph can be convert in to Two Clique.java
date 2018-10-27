import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Check_Divide_Graph_TwoCliques
{
   int v;
   int g[][];
   int temp[][];
   Check_Divide_Graph_TwoCliques(int v)
   {
   this.v=v;
   g=new int[v][v];
   temp=new int[v][v];
   for(int i=0;i<v;i++)
   {
   	for(int j=0;j<v;j++)
   	{
   		g[i][j]=0;
   		temp[i][j]=0;
   	}
   }
   }
   void addEdge(int src,int dest)
   {
   	g[src][dest]=1;
   	g[dest][src]=1;
   }
 boolean isBipartite()
 {
   for(int i=0;i<v;i++)
   {
   	for(int j=0;j<v;j++)
   	{
   		if(i!=j&&g[i][j]==0)
   			temp[i][j]=1;
   		   	}
   }
   int visited[]=new int[v];
   for(int i=0;i<v;i++)
   	  visited[i]=-1;
   	Queue<Integer> q=new LinkedList<>();
   	q.add(0);
   	visited[0]=1;
   	if(temp[0][0]==1)
   		return false;
   	while(!q.isEmpty())

   	{
   		int u=q.poll();
   		for(int i=0;i<v;i++)
   		{
   			if(temp[u][i]==1&&visited[i]==-1)
   			{
   				visited[i]=1-visited[u];
   				q.add(i);
   			}
   			else if(temp[u][i]==1&&visited[i]==visited[u])
   				return false;
   		}
   	}
return true;
 }
 public static void main(String[] args) {
 	Scanner sc=new Scanner(System.in);
 	int v=sc.nextInt();
 	int e=sc.nextInt();
 	Check_Divide_Graph_TwoCliques graph=new Check_Divide_Graph_TwoCliques(v);
 	for(int i=1;i<=e;i++)
 	{
 		int src=sc.nextInt();
 		int dest=sc.nextInt();
 		graph.addEdge(src,dest);
 	}
 	if(graph.isBipartite())
 		System.out.println("Can Be convert in Two Clique");
 	else
 			System.out.println("Can not Be convert in Two Clique");

 }
}
