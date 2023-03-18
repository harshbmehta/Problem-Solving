/*
(On My Own) 

TimeComplexity: O(M) where M is the number of cells in the matrix
Space: O(1) No auxiliary space used
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowEnd = matrix.length-1;
        int rowSt = 0;
        int colEnd = matrix[0].length-1;
        int colSt = 0;
        while(rowSt<=rowEnd && colSt<=colEnd) {
            for(int i=colSt; i<=colEnd;i++) {
                res.add(matrix[rowSt][i]);
            }
            rowSt++;

            for(int j=rowSt;j<=rowEnd;j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if(rowSt <= rowEnd) {
                for(int i=colEnd;i>=colSt;i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;


            if(colSt <= colEnd) {
                for(int i=rowEnd;i>=rowSt;i--) {
                    res.add(matrix[i][colSt]);
                }
            }
            colSt++;
        }
        return res;
    }
}