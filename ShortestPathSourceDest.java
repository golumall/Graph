import java.util.*;

public class findShortestPathInGrid{
    static int number_of_node_left=0;
    static int number_of_node_next=0;
    static void explore(Queue<Integer>q,int mat[][],boolean visited[][],int r,int c,int x,int y)
    {
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int i=0;i<4;i++)
        {
            int rr=x+dr[i];
            int cc=y+dc[i];
            if(rr<0||cc<0||rr>=r||cc>=c||visited[rr][cc]==true)
              continue;
            q.add(rr);
            q.add(cc);
            visited[rr][cc]=true;
            number_of_node_next++;
        }
    }
    static int findShortestPath(int mat[][],boolean visited[][],int r,int c,int srcx,int srcy,int dstx,int dsty)
    {
        if(srcx>=r||srcx<0||srcy>=c||srcy<0||dstx>=r||dstx<0||dsty>=c||dsty<0||mat[srcx][srcy]==0)
            return -1;
        if(srcx==dstx&&srcy==dsty)
          return 0;
        int totalPath=0;  
        boolean find_reached=false;
        Queue<Integer>q=new LinkedList<>();
        q.add(srcx);q.add(srcy);
        visited[srcx][srcy]=true;
        number_of_node_left=1;
        while(!q.isEmpty())
        {
            int x=q.poll();
            int y=q.poll();
            if(x==dstx&&y==dsty){
                find_reached=true;
                break;
            }
            explore(q,mat,visited,r,c,x,y);
            number_of_node_left--;
        if(number_of_node_left==0)
        {
            number_of_node_left=number_of_node_next;
            number_of_node_next=0;
            totalPath++;
        }
            
        }
      if(find_reached)
        return totalPath;
    return -1;    
        
    }
	public static void main (String[] args) {
       Scanner sc=new Scanner(System.in);
       int r=sc.nextInt();
       int c=sc.nextInt();
       int srcx=sc.nextInt();
       int srcy=sc.nextInt();
       int dstx=sc.nextInt();
       int dsty=sc.nextInt();
       
       int mat[][]=new int[r][c];
       boolean visited[][]=new boolean[r][c];
       for(int i=0;i<r;i++)
       {
           for(int j=0;j<c;j++)
           {
               mat[i][j]=sc.nextInt();
               if(mat[i][j]==0)
                  visited[i][j]=true;
           }
       }
       System.out.println(findShortestPath(mat,visited,r,c,srcx,srcy,dstx,dsty));
	}
}


/*
9 10
0 0 3 4
1 0 1 1 1 1 0 1 1 1 
1 0 1 0 1 1 1 0 1 1
1 1 1 0 1 1 0 1 0 1
0 0 0 0 1 0 0 0 0 1
1 1 1 0 1 1 1 0 1 0
1 0 1 1 1 1 0 1 0 0
1 0 0 0 0 0 0 0 0 1
1 0 1 1 1 1 0 1 1 1
1 1 0 0 0 0 1 0 0 1
*/
