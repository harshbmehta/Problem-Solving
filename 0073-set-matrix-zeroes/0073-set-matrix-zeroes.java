class Solution {
    public void setZeroes(int[][] matrix) {
       boolean firstRow = false;
       boolean firstCol = false;
       int rowL = matrix.length;
       int colL = matrix[0].length;

       for(int i=0; i<rowL;i++) {
           if(matrix[i][0] == 0) {
               firstCol = true;
           }
       }

       for(int i=0; i<colL;i++) {
           if(matrix[0][i] == 0) {
               firstRow = true;
           }
       }

       for(int i=1; i<rowL;i++) {
           for(int j=1; j<colL; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
           }
       }

       for(int i=1; i<rowL;i++) {
            for(int j=1; j<colL;j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstCol) {
            for(int i = 0; i<rowL;i++) {
                matrix[i][0] = 0;
            }
        }

        if(firstRow) {
            for(int i = 0; i<colL;i++) {
                matrix[0][i] = 0;
            }
        }
    }
}