/*
Let M be the number of cells in the matrix.

Time complexity : O(M), as each cell is getting read once and written once.

Space complexity : O(1) because we do not use any other additional data structures.

*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int left = 0; 
        int right = n-1;
   
        while(left<right) {
            for(int i=0; i<right-left;i++) { // ****** Right-Left
                int top = left;
                int bottom=right;
                int temp = matrix[top][left+i];

                matrix[top][left+i] = matrix[bottom-i][left];

                matrix[bottom-i][left] = matrix[bottom][right-i];

                matrix[bottom][right-i] = matrix[top+i][right];

                matrix[top+i][right] = temp;
            }
            // ****remember
            left++;
            right--;
        }
    }
}