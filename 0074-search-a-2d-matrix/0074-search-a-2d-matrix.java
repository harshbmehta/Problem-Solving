class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i=0; i<r;i++) {
            if(target > matrix[i][c-1]) {
                continue;
            }
            for(int j=0; j<c;j++) {
                if(target <= matrix[i][c-1] && target >= matrix[i][0]) {
                    if(target == matrix[i][j]) {
                        return true;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
     }
}