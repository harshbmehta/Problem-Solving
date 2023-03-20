/*
Complexity Analysis

    Time complexity: O(n). The input array is traversed at most once. Thus the time complexity is O(n).

    Space complexity: O(1). We only use additional space to store two indices and the sum, so the space complexity is O(1).
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        int res[] = new int[2];

        while(left < right) {
            if(target - numbers[left] < numbers[right]) {
                right --;
                continue;
            }

            if(target - numbers[right] > numbers[left]) {
                left ++;
                continue;
            }

            if(target - numbers[left] == numbers[right]) {
                res[0] = left+1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}