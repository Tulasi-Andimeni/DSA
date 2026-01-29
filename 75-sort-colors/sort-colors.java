class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int height = nums.length -1;
        int mid = 0;

        while(mid <= height){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                if(nums[mid] == 2){
                    int temp = nums[height];
                    nums[height] = nums[mid];
                    nums[mid] = temp;
                    height--;
                    
                }
            }

            
        }
        
    }
}