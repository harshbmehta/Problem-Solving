class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int ROWL;
    int COLL;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWL = heights.length;
        COLL = heights[0].length;

        boolean [][] pacific = new boolean[ROWL][COLL];
        boolean [][] atlantic = new boolean[ROWL][COLL];

        for(int j=0;j<COLL;j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific);
            dfs(heights, ROWL-1, j, Integer.MIN_VALUE, atlantic);
        }

        for(int i=0;i<ROWL;i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, COLL-1, Integer.MIN_VALUE, atlantic);
        }

        for(int i = 0; i<ROWL; i++) {
            for(int j=0;j<COLL; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int i, int j, int preVal, boolean[][]ocean) {
        if(i<0 || j<0 || i>=ROWL || j>=COLL) {
            return;
        }
        
        if(ocean[i][j] || preVal > heights[i][j]) {
            return;
        }

        ocean[i][j] = true;
        dfs(heights, i+1, j, heights[i][j], ocean);
        dfs(heights, i-1, j, heights[i][j], ocean);
        dfs(heights, i, j+1, heights[i][j], ocean);
        dfs(heights, i, j-1, heights[i][j], ocean);
    }
}