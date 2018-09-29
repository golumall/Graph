import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
class Graph
{
	int val;
	int steps;
	Graph(int val,int steps)
	{
	this.val=val;
	this.steps=steps;
	}
}
class Convert_X_Y
{
	static int steps(int src,int dest)
	{
		Set<Graph> visited=new HashSet<>(10000);
		Queue<Graph> q=new LinkedList<>();
		Graph node=new Graph(src,0);
		q.add(node);
		visited.add(node);
		while(!q.isEmpty())
		{
			Graph temp=q.poll();
			visited.add(temp);
			if(temp.val==dest)
				return temp.steps;
			int mul=temp.val*2;
			int sub=temp.val-1;
			//Given Constrains
			if(mul>0&&mul<10000)
			{
				Graph x=new Graph(mul,temp.steps+1);
				q.add(x);
			}
			if(sub>0&&sub<10000)
			{
				Graph y=new Graph(sub,temp.steps+1);
				q.add(y);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int src=sc.nextInt();
		int dest=sc.nextInt();
		System.out.println(steps(src,dest));
	}
	
}


//https://www.geeksforgeeks.org/minimum-number-operation-required-convert-number-x-y/
