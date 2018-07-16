import java.util.Iterator;
import java.util.LinkedList;
public class DepthFirstSearch
{
	int vertices;
	LinkedList<Integer> adj_list[];
	DepthFirstSearch(int v)
	{
		vertices=v;
		adj_list=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj_list[i]=new LinkedList();
		}
	}
	void add_edge(int v,int w)
	{
		adj_list[v].add(w);
	}
	void lookUp(int v,boolean visited_vertices[])
	{
		visited_vertices[v]=true;
		System.out.print(v+" ");
		Iterator<Integer> i=adj_list[v].listIterator();
		while(i.hasNext())
		{
			int remain_vertices=i.next();
			if(!visited_vertices[remain_vertices])
			{
				lookUp(remain_vertices,visited_vertices);
			}
		}
	}
	void DFS(int v)
	{
		boolean visited_vertices[]=new boolean[vertices];
		lookUp(v,visited_vertices);
	}
	public static void main(String[] args) {
		DepthFirstSearch graph=new DepthFirstSearch(5);
		graph.add_edge(0,1);
		graph.add_edge(0,2);
		graph.add_edge(1,2);
        graph.add_edge(2,0);
        graph.add_edge(2,3);
        graph.add_edge(3,3);
        graph.DFS(2);
	}
}
