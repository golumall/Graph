import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
class Coloring_Vertices
{
	int v;
	LinkedList<Integer> adj[];
	Coloring_Vertices(int v)
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
	void coloring()
	{
		int res[]=new int[v];
        Arrays.fill(res,-1);
        boolean color[]=new boolean[v];
        Arrays.fill(color,true);
        res[0]=0;
        for(int i=1;i<v;i++)
        {
        	for(Integer j:adj[i])
        	{
                  if(res[j]!=-1)
                  	color[res[j]]=false;

        	}
        	int cr;
        	for(cr=0;cr<v;cr++)
        		if(color[cr])
        			break;
        	res[i]=cr;
        	Arrays.fill(color,true);
        }
        for(int i=0;i<v;i++)
        	System.out.println(i+"-->"+res[i]);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Coloring_Vertices g=new Coloring_Vertices(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.coloring();
	}

	
}
