package Leetcode;

/**
 * Longest common subsequence
 * Input: two strings X & Y of lengths n & m
 * X = x1, x2...xn
 * Y = y1, y2...yn
 * Output: Length of a LCS of X & Y
 * def: Z is a subsequence of X if Z can be obtained from X by deleting some of the symbols in X
 */
public class LongestCommonSubsequence {
    
    static int[][] opt;
    
    public static void LongestCommonSubsequence(String x, String y){
        
        opt = new int[x.length() + 1][y.length() + 1];
        buildOpt(x, y);
        
        System.out.println("Longest common subsequence length: " + opt[x.length()][y.length()]);
        
    }
    
    public static void buildOpt(String x, String y){
        
        for(int i = 0; i < opt.length; i++){
            for(int j = 0; j < opt[0].length; j++){
                if(i == 0 || j == 0){
                    opt[i][j] = 0;
                }
                else if(x.charAt(i - 1) == y.charAt(j - 1)){
                    opt[i][j] = 1 + opt[i-1][j-1];
                }
                else{
                    opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
                }
                
            }
        }
    }
    
    
    public static void main(String[] args){
        
        
        String x = "client";
        String y = "relent";
        LongestCommonSubsequence(x, y);
        
        for(int i = 0; i < opt.length; i++){
            for(int j = 0; j < opt[0].length; j++){
                System.out.print(opt[i][j]);
            }
            System.out.println("");
        }
        
    }
    
       
    
    
}
