import java.util.Scanner;
class Create_Graph_Through_Degree
{
  public static void main(String[] args) {
  		Scanner sc=new Scanner(System.in);
  		int n=sc.nextInt();
  		int deg[]=new int[n];
  		for(int i=0;i<n;i++)
  			deg[i]=sc.nextInt();
  		printGraph(deg,n);
  	}
  	static void printGraph(int deg[],int n)
  	{
  		int g[][]=new int[n][n];
  		for(int i=0;i<n;i++)
  		{
  			for(int j=0;j<n;j++)
  			{
  				g[i][j]=0;
  			}
  		}
     for(int i=0;i<n;i++)
     {
     	for(int j=i+1;j<n;j++)
     	{
     		if(deg[i]>0&&deg[j]>0)
     		{
     			deg[i]--;
     			deg[j]--;
     			g[i][j]=1;
     			g[j][i]=1;
     		}
     	}
     }
     System.out.println("\n");
     	for(int i=0;i<n;i++)
  		{
  			for(int j=0;j<n;j++)
  			{
  				System.out.print(" "+g[i][j]);
  			}
  			System.out.println();
  		}


  	}	
}
