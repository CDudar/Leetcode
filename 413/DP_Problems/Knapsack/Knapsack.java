
package Leetcode;


/*
* Input: n items
* Weights: w1, w2, ...  wn
* Values: v1, v2, ... vn
* Knapsack of capacity W
* Goal: Fill knapsack w/ as valuable load as possible (cannot overflow, cannot reuse items)
* All weights have an associated value, we want to maximize value in the knapsack. 
*/
public class Knapsack {
        
        static int[][] opt;
        
    
    public static void Knapsack(int n, int[] weights, int[] vals, int capacity){
        opt = new int[n + 1][capacity + 1];
        for(int i = 0; i < n; i++){
            opt[i][0] = 0;
        }
        for(int i = 0; i < capacity; i++){
            opt[0][i] = 0;
        }
        
        buildOpt(n, weights, vals, capacity);
        printOpt(opt, weights, n, capacity);
        System.out.println("");
    }
    
    public static void buildOpt(int n, int[] weights, int[] vals, int capacity){
        
        for(int i = 1; i < opt.length; i++){
            int itemIdx = i - 1;
            for(int j = 1; j < opt[0].length; j++ ){
                //if we can fit the item, pick the max of A) The optimal value we can get by not using it
                // or B) using it and getting its value + the optimal value we can get with the decreased knapsack space
                if(j - weights[itemIdx] >= 0){
                    opt[i][j] = Math.max((opt[i-1][j]), opt[i-1][j-weights[itemIdx]] + vals[itemIdx]);
                }
                else{
                    opt[i][j] = opt[i-1][j];
                }
                
            }
        }  
        
        
        
    }
    
    public static void printOpt(int[][] opt, int[] weights, int i, int j){
        
        if (i == 0 || j == 0) return;
        
        if(opt[i][j] == opt[i-1][j]){
            printOpt(opt, weights, i-1, j);
        }
        else{
            printOpt(opt, weights, i-1, j-weights[i-1]);
            System.out.print(i - 1 + " ");
        }
        
        
        
        return;
    } 
   
    public static void main(String[] args){
        
        Knapsack(3, new int[]{3,6,9}, new int[]{9,8,15}, 9);
        
        
        
        for(int i = 0; i < opt.length; i++){
            for(int j = 0 ; j < opt[0].length; j++){
                System.out.print(opt[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    
    
}
