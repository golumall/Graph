import java.util.Scanner;
class MinCost_Left_Right_Top_Bottom
{
static int row,col;
static int g[][];
static int res[][];
MinCost_Left_Right_Top_Bottom(int row,int col)
{
this.row=row;
this.col=col;
g=new int[row][col];
res=new int[row][col];
}
void shortPath()
{

res[0][0]=g[0][0];
for(int i=0;i<row;i++)
{
	for(int j=0;j<col;j++)
	{
		upDate(i,j);
	}
}
System.out.println(res[row-1][col-1]);

}
static void upDate(int i,int j)
{
	if(i-1>=0&&res[i-1][j]>g[i-1][j]+res[i][j])
	{
		res[i-1][j]=res[i][j]+g[i-1][j];
		upDate(i-1,j);
	}
   if(j-1>=0&&res[i][j-1]>res[i][j]+g[i][j-1])
   {
   	res[i][j-1]=res[i][j]+g[i][j-1];
   	upDate(i,j-1);
   }
   if(i+1<row&&res[i+1][j]>res[i][j]+g[i+1][j])
   {
   	res[i+1][j]=res[i][j]+g[i+1][j];
   	upDate(i+1,j);
   }
   if(j+1<col&&res[i][j+1]>res[i][j]+g[i][j+1])
   {
   	res[i][j+1]=res[i][j]+g[i][j+1];
   	upDate(i,j+1);
   }

}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int row=sc.nextInt();
	int col=sc.nextInt();
	MinCost_Left_Right_Top_Bottom graph=new MinCost_Left_Right_Top_Bottom(row,col);
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			g[i][j]=sc.nextInt();
			res[i][j]=9999999;
		}
	}
	graph.shortPath();
}
	
}
