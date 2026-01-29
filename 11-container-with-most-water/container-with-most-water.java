class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxarea = 0;

        while(left < right){
            int width = right - left;
            int ht = Math.min(height[left], height[right]);
            int area = width * ht;

            maxarea = Math.max(area , maxarea);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
        
    }
}