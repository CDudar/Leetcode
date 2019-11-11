package Leetcode;

/**
 * Problem #419
 * https://leetcode.com/problems/battleships-in-a-board/
 *
 */
public class countBattleships {
    
    
    public static int countBattleships(char[][] board) {
    
        int shipCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    shipCount++;
                    int k = i;
                    int m = j;
                    board[i][j] = '.';
                    while(m + 1 < board[0].length && board[i][++m] == 'X'){
                        board[i][m] = '.';
                    }
                    while(k + 1 < board.length && board[++k][j] == 'X'){
                        board[k][j] = '.';
                    }
                    
                }
            }
        }
        
        return shipCount;
    }
    
    
    
    public static void main(String[] args){
        int shipCount = countBattleships(new char[][] {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}});
    }
}
