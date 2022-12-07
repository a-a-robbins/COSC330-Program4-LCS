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
      
   public static void lcs(String x, String y) {
   
      int m = x.length(); 
      int n = y.length(); 
   
      Status[][] b = new Status[m][n]; 
      int[][] c = new int[m+1][n+1]; 
      
      //compute entries in row-major order
      for(int i = 1; i <= m; i++) {
         for(int j = 1; j <= n; j++) {
           if(x.charAt(i - 1) == y.charAt(j - 1)) {
               c[i][j] = c[i-1][j-1]+1;
               b[i-1][j-1] = Status.MATCH;  
           }
           else if(c[i-1][j] >= c[i][j-1]) {
              c[i][j] = c[i-1][j]; 
              b[i-1][j-1] = Status.UP;  
           }
           else {
               c[i][j] = c[i][j-1]; 
               b[i-1][j-1] = Status.LEFT; 
           }
         }
      }

      // Call print LCS
      build(b, x, m - 1, n - 1);

   }

   // Build LCS
   public static void build(Status[][] b, String x, int i, int j){
      if (i == -1 || j == -1){
         return;
      }
      if (b[i][j] == Status.MATCH){
         build(b, x, i - 1, j - 1);
         System.out.print(x.charAt(i));
      }else if (b[i][j] == Status.UP) {
         build(b, x, i - 1, j);
      }else {
         build(b, x, i, j - 1);
      }
   }

 public static void main(String[] args) {
   String x = "ABCBDABBDA";
   String y = "BDCABABBDA";
    
   lcs(x, y);     
 }
     
}