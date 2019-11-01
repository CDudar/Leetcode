
import java.util.Arrays;

//Problem #654. Maximum Binary Tree
//https://leetcode.com/problems/maximum-binary-tree/
public class MaximumBinaryTree {
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        if(nums.length == 0) return null;
        
        int max = nums[0];
        int maxIdx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){ 
                max = nums[i];
                maxIdx = i;
            }
        }
        
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));
        
        return node;
    }
    
        public static void main(String[] args) {
            System.out.println("started");
            System.out.println(new int[]{1});
            System.out.println(new int[]{3,2,1,6,0,5});

        }
}
