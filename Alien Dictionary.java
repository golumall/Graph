
//Source
//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
class Alien_Dictionary
{
    int v;
    LinkedList<Integer> adj[];
    Stack<Integer> st=new Stack<>();
	Alien_Dictionary(int v)
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
	void topoSortUtil(int i,boolean visited[])
	{
		visited[i]=true;
		for(int j:adj[i])
		{
			if(!visited[j])
				topoSortUtil(j,visited);
		}
		st.push(i);
	}
   void topoSort()
   {
   	boolean visited[]=new boolean[v];
   	for(int i=0;i<v;i++)
   	{
   		if(!visited[i])
   		topoSortUtil(i,visited);
   	}

   while(!st.isEmpty())
   {
   	System.out.print((char)(st.pop()+(int)'a')+" ");
   }
   }
  static void printOrder(String dict[],int v)
   {
      Alien_Dictionary g=new Alien_Dictionary(v);
      for(int i=0;i<dict.length-1;i++)
      {
      	  String word1=dict[i];
      	  String word2=dict[i+1];
      	  for(int j=0;j<Math.min(word1.length(),word2.length());j++)
      	  {
      	  	if(word1.charAt(j)!=word2.charAt(j))
      	  	{
      	  		g.addEdge((int)word1.charAt(j)-'a',(int)word2.charAt(j)-'a');
      	  		break;
      	  	}
      	  }
      }
      g.topoSort();    
   }
   public static void main(String[] args) {
   	Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=(int)'a';
		String []a=new String[n];
		for(int i=0;i<n;i++)
		{
		    a[i]=sc.next();
		}
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<a[i].length();j++)
		    {
		        if((int)a[i].charAt(j)>m)
		        m=(int)a[i].charAt(j);
		    }
		}
		m=m-96;
     printOrder(a,m);
   }
}
