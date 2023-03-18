/*
https://leetcode.com/problems/happy-number/solutions/421162/happy-number/
Approach 4

TimeComplexity: O(log n)
Space: O(1): We are not maintaining any history of numbers we've seen. The hardcoded HashSet is of a constant size.
*/

class Solution {
        public int getNext(int n) {
        int totalSum = 0;
        while(n>0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n = n/10;
        }
        return totalSum;
    }
    
    public boolean isHappy(int n) {
        while (n != 1 && n!=4) {
            n = getNext(n);
        }
        return n == 1;
    }
}