/*Algorithm

stpe1:-count all path from source to destination using Bfs or Dfs here i am using Dfs
step2:and select mimimum of them
*/
//---------------------------------------


import java.util.Scanner;
import java.util.ArrayList;
class Min_Edge
{
	int v;
    int min=Integer.MAX_VALUE;
    
    //ArrayList is use for representation of graph
    ArrayList<Integer> adj[];
    Min_Edge(int v)
    {
    	this.v=v;
    	adj=new ArrayList[v];
    	for(int i=0;i<v;i++)
    	{
    		adj[i]=new ArrayList<Integer>();
    	}
    }   
    //Add Edge Between source and destination Vertices
    void addEdge(int src,int dest)
    {
    	adj[src].add(dest);
    	adj[dest].add(src);
    }
    //Main Method for count minmumu Edge between source and destination
    void minEdge(int src,int dest)
    {
    	boolean []visited=new boolean[v];
    	ArrayList<Integer> edge=new ArrayList<Integer>();
    	edge.add(src);
    	allEdge(src,dest,visited,edge);
    	System.out.println(min);
    	
    }
    //Utility methode which call by addEdge Method for implementaion of Dfs
    void allEdge(int src,int dest,boolean visited[],ArrayList<Integer> edge)
    {
    	visited[src]=true;
    	if(src==dest)
    	{
    		int count=0;
    		
    		for(Integer j:edge)
    		{
    			count++;

    		}
    		if(count-1<min)
    		{
    		  min=count-1;
    		 
    		}
    		
    	}
    	for(Integer i:adj[src])
    	{
    		if(!visited[i])
    		{
    			edge.add(i);
    			allEdge(i,dest,visited,edge);
    			edge.remove(i);

    		}
    	}
      visited[src]=false;
    }
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int v=sc.nextInt();
      	int e=sc.nextInt();
      Min_Edge g=new Min_Edge(v);
      for(int i=1;i<=e;i++)
      {
      	int src=sc.nextInt();
      	int dest=sc.nextInt();
      	g.addEdge(src,dest);
      }
      	int src=sc.nextInt();
      	int dest=sc.nextInt();
      	g.minEdge(src,dest);
    }
}
