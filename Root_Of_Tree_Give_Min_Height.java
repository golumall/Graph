import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Root_Of_Tree_Give_Min_Height
{
	int v,min=Integer.MAX_VALUE;
	LinkedList<Integer> adj[];
	Root_Of_Tree_Give_Min_Height(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=1;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	void height()
	{
		boolean visited[]=new boolean[v];
		Queue<Integer> q1=new LinkedList<>();
		Queue<Integer> q2=new LinkedList<>();
		for(int i=1;i<v;i++)
		{
			q1.add(i);
			visited[i]=true;
			int h=-1,f=0;
			while(!q1.isEmpty()||!q2.isEmpty())
			{
				while(!q1.isEmpty())
				{
					f=1;
					int p=q1.poll();
					for(Integer j:adj[p])
					{
						if(!visited[j])
						{
							visited[j]=true;
							q2.add(j);
						}
					}

				}
				if(f==1)
				{
				h++;
				f=0;
			}
				while(!q2.isEmpty())
				{
					f=1;
					int p=q2.poll();
					for(Integer j:adj[p])
					{
						if(!visited[j])
						{
							visited[j]=true;
							q1.add(j);
						}
					}
				}
				if(f==1)
				{
					h++;
					f=0;
				}
			}
			if(h<min)
				min=h;
			for(int j=1;j<v;j++)
			{
				visited[j]=false;
			}
		}
		System.out.println(min);
	}
   public static void main(String[] args) {
   		Scanner sc=new Scanner(System.in);
   		int v=sc.nextInt();
   		int e=sc.nextInt();
   		Root_Of_Tree_Give_Min_Height g=new Root_Of_Tree_Give_Min_Height(v+1);
   		for(int i=1;i<=e;i++)
   		{
   			int src=sc.nextInt();
   			int dest=sc.nextInt();
   			g.addEdge(src,dest);
   		}
   		g.height();
   	}	
}
