class Solution {
    public boolean exist(char[][] board, String word) {
         
        int rowL = board.length;
        int colL = board[0].length;
        for(int i=0;i<rowL;i++) {
            for(int j=0;j<colL;j++) {
                if(findWord(board, word, i , j, rowL, colL, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int i, int j, int rowL, int colL, int start) {
        if(start == word.length()) {
            return true;
        }
        if(i<0 || i>=rowL || j<0 || j>=colL || board[i][j] != word.charAt(start)) {
            return false;
        }
        boolean exists = false;
        board[i][j] += 100;
        exists = (findWord(board, word, i+1, j, rowL, colL, start+1) || 
            findWord(board, word, i-1, j, rowL, colL, start+1) ||
            findWord(board, word, i, j+1, rowL, colL, start+1) ||
            findWord(board, word, i, j-1, rowL, colL, start+1));
        board[i][j] -= 100;
        return exists;
    }
}