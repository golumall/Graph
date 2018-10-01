//Source
//https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/

import java.util.Scanner;
import java.util.LinkedList;
class Check_Two_Node_In_Same_Path_Or_Not
{
  int v,time=0;
  LinkedList<Integer> adj[];
  int timeIn[];
  int timeOut[];
  boolean visited[];
  Check_Two_Node_In_Same_Path_Or_Not(int v)
  {
  	this.v=v;
  	adj=new LinkedList[v];
  	timeIn=new int[v];
  	timeOut=new int[v];
  	visited=new boolean[v];
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
void dfs(int s)
{
   visited[s]=true;
   time++;
   timeIn[s]=time;
   for(Integer i:adj[s])
   {
   	if(!visited[i])
   		dfs(i);
   }
   time++;
   timeOut[s]=time;
}
boolean check(int src,int dest)
{
	return ((timeIn[src]<timeIn[dest]&&timeOut[src]>timeOut[dest])||(timeIn[dest]<timeIn[src]&&timeOut[dest]>timeOut[src]));
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Check_Two_Node_In_Same_Path_Or_Not g=new Check_Two_Node_In_Same_Path_Or_Not(v+1);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		g.addEdge(src,dest);
	}
	g.dfs(1);
	int q=sc.nextInt();
	while(q-->0)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		if(g.check(src,dest))
		System.out.println("YES");
	   else
	   	System.out.println("NO");
	}
}
}
