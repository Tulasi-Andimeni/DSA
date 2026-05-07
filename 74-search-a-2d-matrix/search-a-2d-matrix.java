class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int clos = matrix[0].length;

        int low = 0;
        int high = rows * clos -1;

        while(low <= high){
            int mid = (low + high) /2;

            int row = mid/clos;
            int clo = mid % clos;

            int value = matrix[row][clo];

            if(value == target){
                return true;
            }
            else if(value < target ){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }

            
        }
        return false;
    }
}