class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWL = grid.length;
        int COLL = grid[0].length;

        int count = 0;
        int fresh = 0;
        Queue<int[]> pque = new LinkedList<>();

        for(int i=0;i<ROWL; i++) {
            for(int j=0; j<COLL; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    pque.offer(new int[]{i, j});
                }           
            }
        }

        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        while(!pque.isEmpty() && fresh != 0) { // w/0 fresh != 0 count is returing to be 1 more than expected
            int sz = pque.size();
            count++;
            for(int i=0; i<sz; i++) {
                int [] orangeRot = pque.poll();
                for(int []dir: dirs) {
                    int x = orangeRot[0]+dir[0];
                    int y = orangeRot[1]+dir[1];
                    if(x >= 0 && x<ROWL && y >=0 && y<COLL && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        pque.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0? count: -1;
    }
}