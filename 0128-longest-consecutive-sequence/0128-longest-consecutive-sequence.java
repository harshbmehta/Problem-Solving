/*
Time Complexity: O(n)
Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for n iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n⋅n) complexity, the nested loops actually run in O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.

Space Complexity: O(n)

In order to set up O(1) containment lookups, we allocate linear space for a hash table to store the O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLength = 0;

        Set<Integer> numSet = new HashSet<>();
        for(int i: nums) {
            numSet.add(i);
        }

        for(int num: numSet) {
            if(!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                    while(numSet.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
                maxLength = Math.max(currentStreak, maxLength);
            }
        }
     return maxLength;
    }
}