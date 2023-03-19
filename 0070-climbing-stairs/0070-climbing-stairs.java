// Logic is well explained here: https://www.youtube.com/watch?v=Y0lT9Fck7qI
// Time: O(n)
// Space: O(1)

class Solution {
    public int climbStairs(int n) {
        int res = 0;
        int one = 1;
        int two = 1;
        for(int i = 0;i<n-1;i++) {
            res = one + two;
            two = one;
            one = res;
        }
        return one;
    }
}