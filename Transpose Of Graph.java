/*package whatever //do not write package name here */

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
class Transpose_Of_Graph {
    int v;
    LinkedList<Integer> adj[];
    Transpose_Of_Graph(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }
    void printGraph()
    {
        System.out.println();
        for(int i=0;i<v;i++)
        {
            System.out.print(i);
            for(Integer j:adj[i])
            {
                System.out.print("-->"+j);
            }
            System.out.println();
        }
    }
    void transPose()
    {
        Transpose_Of_Graph gr=new Transpose_Of_Graph(v);
        for(int i=0;i<v;i++)
        {
            for(Integer j:adj[i])
            {
                gr.adj[j].add(i);
            }
        }
        System.out.println();
        for(int i=0;i<v;i++)
        {
            System.out.print(i);
            for(Integer j:gr.adj[i])
            {
                System.out.print("-->"+j);
            }
            System.out.println();
        }
    }
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Transpose_Of_Graph g=new Transpose_Of_Graph(v);
		for(int i=1;i<=e;i++)
		{
		    int src=sc.nextInt();
		    int dest=sc.nextInt();
		    g.addEdge(src,dest);
		}
		g.printGraph();
		g.transPose();
	
	}
}
