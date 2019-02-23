

//https://ide.geeksforgeeks.org/mvqvMHW9VM
//Sources
//https://www.geeksforgeeks.org/find-number-of-islands/



import java.util.*;

class NumberOfIsland {
     boolean isSafe(int m[][],int x,int y,int r,int c,boolean visited[][])
     {
         return (x>=0&&x<r&&y>=0&&y<c&&m[x][y]==1&&!visited[x][y]);
     }
   void dfs(int m[][],int x,int y,int r,int c,boolean visited[][])
    {
        visited[x][y]=true;
        int rn[]={-1,-1,-1,0,0,1,1,1};
        int cn[]={-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<8;i++)
        {
            if(isSafe(m,x+rn[i],y+cn[i],r,c,visited))
               dfs(m,x+rn[i],y+cn[i],r,c,visited);
        }
        
    }
    int findIsland(int m[][],int r,int c)
    {
        int count=0;
        boolean visited[][]=new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(m[i][j]==1&&!visited[i][j])
                {
                dfs(m,i,j,r,c,visited);
                count++;
                }
                
            }
        }
        return count;
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		NumberOfIsland ob=new NumberOfIsland();
		int r=sc.nextInt();
		int c=sc.nextInt();
		int m[][]=new int[r][c];
		for(int i=0;i<r;i++)
		{
		    for(int j=0;j<c;j++)
		    {
		        m[i][j]=sc.nextInt();
		    }
		}
		System.out.println(ob.findIsland(m,r,c));
	}
}
