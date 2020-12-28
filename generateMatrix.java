import java.io.*; 
import java.util.*; 


/* 
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]


Example 2:
Input: n = 1
Output: [[1]]


https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/

Constraints:

1 <= n <= 20
*/



class generateMatrix {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    
    print2D(generateMatrix(3));
  }

  

  public static int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int xBoundLeft = 0;
        int xBoundRight = n;
        
        int yBoundUp = 0;
        int yBoundDown = n;
        
        int xPos = 0;
        int yPos = 0;
        int i = 1; 
        
        int x = 0; 
        int y = 0;
        while( i <= n*n) {
            for(y = xBoundLeft; y < xBoundRight; y ++) { // right [0,1] = 1, [0,2] = 2, [0,3] = 3
                System.out.println("Current position = [" +xPos + "][" + y + "] = " + i);
                matrix[xPos][y] = i;
                i++;
            }
            yPos = y-1;
            yBoundUp ++;
            System.out.println("");
            for(x = yBoundUp; x < yBoundDown; x ++) { // down [1,3] = 4,
                System.out.println("Current position = [" +x + "][" + yPos + "] = " + i);
                matrix[x][yPos] = i;
                i ++;
            }
            xPos = x-1;
            xBoundRight --;
            System.out.println("");
            
            for(y = xBoundRight-1; y >= xBoundLeft; y--) { // left
                System.out.println("Current position = [" +xPos + "][" + y + "] = " + i);
                matrix[xPos][y] = i;
                i++;
            }
            yPos = y+1; 
            yBoundDown --;
            System.out.println("");
            
            for(x = yBoundDown-1; x >= yBoundUp; x--) {
                System.out.println("Current position = [" +x + "][" + yPos + "] = " + i);
                matrix[x][yPos] = i;
                i++;
            }
            xPos = x+1;
            xBoundLeft ++;    
            System.out.println("");       
        }
        return matrix;
    }

    public static void print2D(int mat[][]) //from https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
    { 
        // Loop through all rows 
        for (int[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    }
}