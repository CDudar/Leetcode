package Leetcode;

//Problem #540
//must run in O(log n) time
public class SingleElementInASortedArray {
    
        public static int singleNonDuplicate(int[] nums) {
            
        if(nums.length == 1) return nums[0];
            
        boolean numNotFound = true;
        int mid = 0;
        
        int neighborL;
        int neighborR;
        
        int high = nums.length - 1;
        int low = 0;
        
        while(numNotFound){
            mid = low + (high - low) / 2;

            if(mid - 1 >= 0) neighborL = nums[mid-1]; else neighborL = -1; //if at beginning of list make left neighbor not equal to element 
            if(mid + 1 < nums.length) neighborR = nums[mid+1]; else neighborR = -1; //if at end of list make right neighbor not equal to element
            
            if(neighborL != nums[mid] && neighborR != nums[mid]){
                numNotFound = false;
            }
            
            else if(neighborL == nums[mid]){
                
                if(mid % 2 == 0){
                //number must be to the left of mid & neighbor
                    high = mid - 2;
                }
                //number must be to right of mid
                else{
                    low = mid + 1;
                }
            }
            //Right neighbor must equal mid
            else  {
                //number must be to right of mid & neighbor
                if(mid % 2 == 0){
                    low = mid + 2;
                }
                //number must be to left of mid
                else{
                    high = mid - 1;
                }
            }
        }
        
        return nums[mid];
    }
      
        
        public static void main(String[] args) {
            System.out.println("started");

            System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
            System.out.println(singleNonDuplicate(new int[]{2, 2, 3, 3, 7, 7, 10, 11, 11}));
            System.out.println(singleNonDuplicate(new int[]{2, 2, 3, 7, 7, 11, 11, 12, 12, 13, 13, 14, 14}));            
            System.out.println(singleNonDuplicate(new int[]{1}));
            System.out.println(singleNonDuplicate(new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}));
             
        }

}
