// LCS non-recursive
// COSC 330 - Algorithms
// Ashley Robbins & Trong Bao
// Nov 28, 2022
 
public class LCS {

   private enum Status {
      MATCH, 
      LEFT, 
      UP
   }
      
   public static String lcs(String x, String y) {
   
      int m = x.length(); 
      int n = y.length(); 
   
      Status[][] b = new Status[m-1][n-1]; 
      int[][] c = new int[m][n]; 
      
      //fill table c with 0's
      for(int i = 1; i < m; i++) {
         c[i][0] = 0; 
      }  
      
      for(int j = 0; j < n; j++) {
         c[0][j] = 0; 
      }  
      
      //compute entries in row-major order
      for(int i = 1; i < m; i++) {
         for(int j = 1; j < n; j++) {
           if(x.charAt(i) == y.charAt(i)) {
               c[i][j] = c[i-1][j-1]+1; 
               b[i][j] = Status.MATCH;  
           }
           else if(c[i-1][j] >= c[i][j-1]) {
              c[i][j] = c[i-1][j]; 
              b[i][j] = Status.UP;  
           }
           else {
               c[i][j] = c[i][j-1]; 
               b[i][j] = Status.LEFT; 
           }
         }
      }
   
      return "retVal"; 
   }


 public static void main(String[] args) {
    String x = "ABCBDAB";
    String y = "BDCABA";
    
    System.out.println(lcs(x,y)); 
    
        
 }
     
}