import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Petersion_Graph
{
	LinkedList<Integer> adj[];
	String res="";
	char lable[]={'A','B','C','D','E','A','B','C','D','E'};
   Petersion_Graph()
   {
   	adj=new LinkedList[10];
   	for(int i=0;i<10;i++)
   	{
   		adj[i]=new LinkedList<>();
   	}
   }
   void addEdge(int src,int dest)
   {
   	adj[src].add(dest);
   	adj[dest].add(src);
   }
   boolean check(String s,int index)
   {
   	res="";
   	res=res+Integer.toString(index);
   	boolean pos;
   	int i;
   	for(i=1;i<s.length();i++)
   	{
   		pos=false;
   		for(Integer j:adj[index])
   		{
   			if(lable[j]==s.charAt(i))
   			{
   				index=j;
   				res+=Integer.toString(j);
   				pos=true;
   				break;
   			}
   		}
   		if(!pos)
   			return false;
   	}
   	return true;
   }
   void petersion(String s)
   {
    if(s.charAt(0)=='A')
    {
    	if(check(s,0)||check(s,5))
    		System.out.println(res);
    	else
    		System.out.println("-1");
    }
    else if(s.charAt(0)=='B')
    {
    	if(check(s,1)||check(s,6))
    		System.out.println(res);
    	else
    		System.out.println("-1");
    }
    else if(s.charAt(0)=='C')
    {
    	if(check(s,2)||check(s,7))
    		System.out.println(res);
    	else
    		System.out.println("-1");
    }
    else if(s.charAt(0)=='D')
    {
    	if(check(s,3)||check(s,8))
    		System.out.println(res);
    	else
    		System.out.println("-1");
    }
    else 
    {
    	if(check(s,4)||check(s,9))
    		System.out.println(res);
    	else
    		System.out.println("-1");
    }
   }
   public static void main(String[] args) {
   		Petersion_Graph g=new Petersion_Graph();
   		Scanner sc=new Scanner(System.in);
   		g.addEdge(0,5);
   		g.addEdge(0,4);
   		g.addEdge(0,1);

   		g.addEdge(1,6);
   		g.addEdge(1,2);
   		
        g.addEdge(2,7);
   		g.addEdge(2,3);
   		
   		g.addEdge(3,8);
   		g.addEdge(3,4);

   		g.addEdge(4,9);
   		
   		g.addEdge(5,8);
        g.addEdge(5,7);

        g.addEdge(6,9);
        g.addEdge(6,8);

        g.addEdge(7,5);
        g.addEdge(7,9);
   		
   		int t=sc.nextInt();
     while(t-->0)
     {
      String s=sc.next();
   		g.petersion(s);
   	}
   		
   	}	
	
}

//https://www.geeksforgeeks.org/peterson-graph/    source
