// Time complexity: O(N)=.

// Inserting the interval initially will take O(N) time as we might end up iterating over the complete list; also, inserting into the list at the mentioned position will take O(N) time. Then iterating over the intervals and merging them with intervals ahead of it will take another O(N) time. Hence, the total time complexity will equal O(N).

// Space complexity: O(1).

// Inserting an interval into the list will take O(1) space. Therefore, apart from the list we return, the total space complexity would be constant.


class Solution {
    // Returns true if the intervals a and b have a common element.
    private boolean doesIntervalsOverlap(int[] a, int[] b) {
        return (Math.min(a[1],b[1]) - Math.max(a[0],b[0])) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    private int[] mergeIntervals(int[] a, int[] b) {
        int res[] = {Math.min(a[0],b[0]), Math.max(a[1], b[1])};
        return res;
    }

    // Insert the interval newInterval, into the list interval keeping the sorting order intact.
    private int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> intervalLs = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                // Found the position, insert the interval and break from the loop.
                intervalLs.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }
        
        // If there is no interval with a greater value of start value,
        // then the interval must be inserted at the end of the list.
        if(!isIntervalInserted) {
            intervalLs.add(newInterval);
        }

        return intervalLs.toArray(new int[intervalLs.size()][2]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the interval first before merge processing.
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();     
        for(int i=0; i<intervals.length;i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            while(i<intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            answer.add(currInterval);
            i--;
        }
        return answer.toArray(new int[answer.size()][2]);
        }
    }