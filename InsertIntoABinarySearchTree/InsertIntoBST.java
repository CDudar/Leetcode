
package Leetcode;

//Problem #701 
//Insert into a Binary Search Tree
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertIntoBST {
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null)
            return new TreeNode(val);
        
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
     
    }
    
}
