import java.util.Scanner;
class Adjacency_Matrix_Graph
{
	boolean adjMatrix[][];
	int vertexCount;
	public Adjacency_Matrix_Graph(int vertexCount)
	{
	this.vertexCount=vertexCount;
	adjMatrix=new boolean[vertexCount][vertexCount];
	}
	public void addEdge(int i,int j)
	{
	if(i>=0&&i<vertexCount&&j>=0&&j<vertexCount)
	{
       adjMatrix[i][j]=true;
       adjMatrix[j][i]=true;
	}
	}
    public void removeEdge(int i,int j)
    {
    	if(i>=0&&i<vertexCount&&j>=0&&j<vertexCount)
    	{
    		adjMatrix[i][j]=false;
    		adjMatrix[j][i]=false;
    	}
    }
    public boolean isEdge(int i,int j)
    {
          if(i>=0&&i<vertexCount&&j>=0&&j<vertexCount)
          	return adjMatrix[i][j];
          else
          	return false;
    }
    public void printMatrix()
    {
    	int i,j;
    	for(i=0;i<vertexCount;i++)
    	{
          for(j=0;j<vertexCount;j++)
          {
          	System.out.print(adjMatrix[i][j]+" ");
          }
           System.out.println();
    	}

    }
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	//Number of Vertex in Graph
    	int n=sc.nextInt();
    	Adjacency_Matrix_Graph graph=new Adjacency_Matrix_Graph(n);
    	int i,j;
    	for(i=0;i<n;i++)
    	{
    		for(j=0;j<n;j++)
    		{

    			graph.adjMatrix[i][j]=sc.nextBoolean();
    		}
    	}
    do
    {
    	System.out.println("\n1)Print\n2)IsEdge\n3)AddEdge\n4)RemoveEdge\n5)Exit!");
         i=sc.nextInt();
         switch(i)
         {
         	case 1:
         	 graph.printMatrix();
         	 break;
         	case 2:
         	if(graph.isEdge(sc.nextInt()-1,sc.nextInt()-1)==true)
         		
         		{
         			System.out.println("Edge");
         			break;
         		}
         	else
         	{

         		System.out.println("Not Edge");
         		break;
         		}
         	
         	case 3:
         	graph.addEdge(sc.nextInt()-1,sc.nextInt()-1);
         	break;
         	case 4:
         	graph.removeEdge(sc.nextInt()-1,sc.nextInt()-1);
         	break;
         	default :
         	break;
         }


    }while(i<5);


    }

}

/*Input

4
false true true false
true false false true
true false false true
false true true false

1)Print
2)IsEdge
3)AddEdge
4)RemoveEdge
5)Exit!
1

Output
false true true false
true false false true
true false false true
false true true false
*/
