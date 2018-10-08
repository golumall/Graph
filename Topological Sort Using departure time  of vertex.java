import java.util.Scanner;
import java.util.LinkedList;
class TopoSort_Using_Departure_Time
{
	int v;
	LinkedList<Integer> adj[];
	boolean visited[];
		int trans[];
		int time;
	TopoSort_Using_Departure_Time(int v)
	{
		this.v=v;
           adj=new LinkedList[v];
           visited=new boolean[v];
           trans=new int[v];
           this.time=-1;
           for(int i=0;i<v;i++)
           {
           	visited[i]=false;
           }
           for(int i=0;i<v;i++)
           {
           	adj[i]=new LinkedList<>();
           }
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
	}
	void dfsUtil(int k,int trans[],boolean visited[],int time)
	{
		visited[k]=true;
		for(Integer j:adj[k])
		{
			if(!visited[j])
				dfsUtil(j,trans,visited,time);
		}
		
		trans[++time]=k;
	}
	void topoSort()
	{
		int i;
		
        for( i=0;i<v;i++)
        {
        	trans[i]=-1;
        }
        for(i=0;i<v;i++)
        {
        	if(!visited[i])
        	{
           dfsUtil(i,trans,visited,time);
           }
        }
        

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		TopoSort_Using_Departure_Time g=new TopoSort_Using_Departure_Time(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.topoSort();
		for(int i=v-1;i>=0;i--)
        {
        	System.out.print(g.trans[i]+" ");
        }
	}

}
