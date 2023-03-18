class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        for(int i=0; i<intervals.length;i++) {
            int[] currInterval = {intervals[i][0],intervals[i][1]};
            while(i<intervals.length && doesOverlap(currInterval,intervals[i])) {
                currInterval = mergeInterval(currInterval, intervals[i]);
                i++;
            }
            i--;
            ans.add(currInterval);
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    private boolean doesOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    private int[] mergeInterval(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])};
    }
}