
//Source
//https://www.geeksforgeeks.org/check-graphs-cycle-odd-length/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Graph_Contains_Odd_Length_Cycle_Or_Not
{
	//if a graph is Bipartite then it will not contain odd length cycle
	int v;
	int g[][];
    Graph_Contains_Odd_Length_Cycle_Or_Not(int v)
    {
    	this.v=v;
    	g=new int [v][v];
    	for(int i=0;i<v;i++)
    	{
    		for(int j=0;j<v;j++)
    		{
    			g[i][j]=0;
    		}
    	}
    }
    void addEdge(int src,int dest)
    {
    	g[src][dest]=1;
    	g[dest][src]=1;
    }
    boolean isOddCycle()
    {
    	int visited[]=new int[v];
    	for(int i=0;i<v;i++)
    		visited[i]=-1;
    	Queue<Integer> q=new LinkedList<>();
    	q.add(0);
    	visited[0]=1;
    	if(g[0][0]==1)
    		return false;
    	while(!q.isEmpty())
    	{
    		int u=q.poll();
    		for(int j=0;j<v;j++)
    		{
              if(g[u][j]==1&&visited[j]==-1)
              {
              	visited[j]=1-visited[u];
              	q.add(j);
              }
              else if(g[u][j]==1&&visited[u]==visited[j])
              	return false;
    		}
    	}
    	return true;
    }
     public static void main(String[] args) {
     	Scanner sc=new Scanner(System.in);
     	int v=sc.nextInt();
     	int e=sc.nextInt();
      Graph_Contains_Odd_Length_Cycle_Or_Not gf=new Graph_Contains_Odd_Length_Cycle_Or_Not(v);
      for(int i=1;i<=e;i++)
      {
      	int src=sc.nextInt();
      	int dest=sc.nextInt();
      	gf.addEdge(src,dest);
      }
      if(gf.isOddCycle())
        System.out.println("Not Odd Cycle");    	
      else
      	System.out.println("Odd Cycle");    	
     }
}
