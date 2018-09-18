import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Remain_Bipartite
{
	int v;
	LinkedList<Integer> adj[];
	Remain_Bipartite(int v)
	{
		this.v=v;
		adj=new LinkedList[v+1];
		for(int i=1;i<=v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
   int maxNumberEdge()
   {
   	int i,count0=0,count1=0;
   	int []visited=new int[v+1];
     for(i=1;i<=v;i++)
         visited[i]=-1;
     Queue<Integer> q=new LinkedList<>();
     q.add(1);
     visited[1]=1;
      count1++;
      while(!q.isEmpty())
      {
          Queue<Integer> temp=new LinkedList<>();
      	while(!q.isEmpty())
      	{
      	int u=q.poll();
      	for(Integer j:adj[u])
      	{
      		if(visited[j]==-1)
      		{
      			temp.add(j);
      			visited[j]=1-visited[u];
      			if(visited[j]==0)
      				count0++;
      			else if(visited[j]==1)
      				count1++;
      		}
      	}
      }
      q=temp;

      }
     
    return ((count0*count1)-(v-1));
   }
   public static void main(String[] args) {
   	Scanner sc=new Scanner(System.in);
   	int v=sc.nextInt();
   	int e=sc.nextInt();
   	Remain_Bipartite g=new Remain_Bipartite(v);
   	for(int i=1;i<=e;i++)
   	{
         int src=sc.nextInt();
         int dest=sc.nextInt();
         g.addEdge(src,dest);
   	}
   	System.out.println(g.maxNumberEdge());
   }
	
}
