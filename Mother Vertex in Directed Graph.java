/*package whatever //do not write package name here */

import java.io.*;
import java.util.Scanner;
class MotherVertex{
    int v;
    int mat[][];
    MotherVertex(int v)
    {
        this.v=v;
        mat=new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                mat[i][j]=0;
            }
        }
    }
    void addEdge(int src,int dest)
    {
        mat[src][dest]=1;
    }
    void dfs()
    {
        for(int i=0;i<v;i++)
        {
            int f=0;
            boolean visited[]=new boolean[v];
            dfsUtil(i,visited);
            for(int j=0;j<v;j++)
            {
                if(visited[j]==false)
                   f=1;
            }
            if(f==0)
              {
                  System.out.println(i);
                  break;
              }
               
        }
    }
    void dfsUtil(int s,boolean visited[])
    {
        visited[s]=true;
        for(int i=0;i<v;i++)
        {
            if(mat[s][i]==1&&!visited[i])
               dfsUtil(i,visited);
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		MotherVertex g=new MotherVertex(v);
		for(int i=1;i<=e;i++)
		{
		    int src=sc.nextInt();
		    int dest=sc.nextInt();
		    g.addEdge(src,dest);
		}
	//	int s=sc.nextInt();
		g.dfs();
	}
}
