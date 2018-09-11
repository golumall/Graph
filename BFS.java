import java.util.Scanner;
import java.util.LinkedList;
class Bfs
{
    int v;
    LinkedList<Integer> adj[];
    Bfs(int v)
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
    void mainbfs(int s)
    {
    	boolean []visited=new boolean[v];
    	LinkedList<Integer> queue=new LinkedList<Integer>();
    	visited[s]=true;
    	queue.add(s);
    	while(queue.size()!=0)
    	{
                s=queue.poll();
                System.out.print(s+" ");
                for(Integer i:adj[s])
                {
                	if(!visited[i])
                	{
                		queue.add(i);
                		visited[i]=true;
                	}
                }
    	}
    }
    public static void main(String ar[])
    {
    	Scanner sc=new Scanner(System.in);
    	int v=sc.nextInt();
    	int e=sc.nextInt();
    	Bfs b=new Bfs(v);
    	for(int i=1;i<=e;i++)
    	{
    		int src=sc.nextInt();
    		int dest=sc.nextInt();
    		b.addEdge(src,dest);
    	}
    	//Vertices which you want to access Bfs
    	int s=sc.nextInt();
    	b.mainbfs(s);
    	//Note:-If vertices start with 0
    }
}
