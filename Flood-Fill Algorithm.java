Flood fill algorithm helps in visiting each and every point in a given area. It determines the area connected to a given cell in a multi-dimensional array. Following are some famous implementations of flood fill algorithm:

Bucket Fill in Paint: 
Clicking in an area with this tool selected fills that area with the selected color.

Solving a Maze: 
Given a matrix with some starting point, and some destination with some obstacles in between, this algorithm helps to find out the path from source to destination

Minesweeper: 
When a blank cell is discovered, this algorithm helps in revealing neighboring cells. This step is done recursively till cells having numbers are discovered.

Flood fill algorithm can be simply modeled as graph traversal problem, representing the given area as a matrix and considering every cell of that matrix as a vertex that is connected to points above it, below it, to right of it, and to left of it and in case of 8-connections, to the points at both diagonals also. For example, consider the image given below.

enter image description here
It clearly shows how the cell in the middle is connected to cells around it. For instance, there are 8-connections like there are in Minesweeper (clicking on any cell that turns out to be blank reveals 8 cells around it which contains a number or are blank). The cell  is connected to        .

In general any cell  is connected to        . Of course, the boundary conditions are to be kept in mind.

Now that the given area has been modeled as a graph, a DFS or BFS can be applied to traverse that graph. The pseudo code is given below.


function DFS(x, y, visited, n, m)
    if (x ≥ n OR y ≥ m)
        return
    if(x < 0 OR y < 0)
        return
    if(visisted[x][y] == True)
        return
    visited[x][y] = True
    DFS(x-1, y-1, visited, n, m)
    DFS(x-1, y, visited, n, m)
    DFS(x-1, y+1, visited, n, m)
    DFS(x, y-1, visited, n, m)
    DFS(x, y+1, visited, n, m)
    DFS(x+1, y-1, visited, n, m)
    DFS(x+1, y, visited, n, m)
    DFS(x+1, y+1, visited, n, m)
The above code visits each and every cell of a matrix of size  starting with some source cell. Time Complexity of above algorithm is .

One another use of flood algorithm is found in solving a maze. Given a matrix, a source cell, a destination cell, some cells which cannot be visited, and some valid moves, check if the destination cell can be reached from the source cell. Matrix given in the image below shows one such problem.

enter image description here
The source is cell  and the destination is cell . Cells containing  cannot be visited. Let's assume there are  valid moves - move up, move down, move left and move right.

Following pseudo code solve the problem given above.


function DFS(x, y, visited, n, m, mat, dest_x, dest_y)
    if(x == dest_x AND y == dest_y)
        return True
    if(x ≥ n OR y ≥ m)
        return False
    if(x < 0 OR y < 0)
        return False
    if(visisted[x][y] == True)
        return False
    if(mat[x][y] == X)
        return False
    visited[x][y] = True
    if (DFS(x+1, y, visited, n, m, mat,  dest_x, dest_y) == True)
        return True
    if (DFS(x-1, y, visited, n, m, mat,  dest_x, dest_y) == True)
        return True
    if (DFS(x, y+1, visited, n, m, mat,  dest_x, dest_y) == True)
        return True
    if (DFS(x, y-1, visited, n, m, mat,  dest_x, dest_y) == True)
        return True
    return False
    
 Example:-
 
 Micro just bought a maze, that can be represented as a matrix A of size , where rows are numbered from 1 to N and columns are numbered from 1 to M. Each cell of the matrix can be either 0 or 1. If a cell is 0, that means it cannot be visited and if it is 1, then it can be visited. Allowed moves are up, down, left and right. Help Micro to find out if he can reach from the cell  to the cell , it is guaranteed that the cells  and have value 1.

Input:
First line consists of a two space separated integers denoting N and M.
Following N lines consists of M space separated integers denoting the matrix A.

Output:
Print "Yes" (without quotes), if Micro can reach from cell  to  otherwise print "No" (without quotes).

Constraints:
 1<=N,M<=10
 0<=A[i][j]<=1
 
Solution:-

import java.util.*;
class TestClass {
    static void check(int n,int m,int mat[][])
    {
        boolean visited[][]=new boolean[n][m];
        return checkUtil(0,0,n,m,mat,visited);
    }
    static boolean checkUtil(int x,int y,int n,int m,int mat[][],boolean visited[][])
    {
        if(x==n-1&&y==m-1)
          return true;
        if(x>=n||y>=m)
          return false;
        if(x<0||y<0)
          return false;
        if(visited[x][y]==true)
          return false;
        if(mat[x][y]==0)
          return false;
        visited[x][y]=true;  
        if(checkUtil(x+1,y,n,m,mat,visited))
           return true;
        if(checkUtil(x-1,y,n,m,mat,visited))
           return true;
        if(checkUtil(x,y+1,n,m,mat,visited))
           return true;
        if(checkUtil(x,y-1,n,m,mat,visited))
           return true;  
    return false;       
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        if(check(n,m,mat))
          System.out.println("Yes");
        else
          System.out.println("No");
    }
}


    
    
