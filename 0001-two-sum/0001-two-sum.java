// Naive solution would be to take one element and iterate through all the remaining to see if it matches target value. This is brute force solution with complexity O(n^2). 
// Method: One pass HashTable
/*
    Time complexity: O(n). We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.

    Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> numMap = new HashMap<>();
       int[] res = new int[2];
       for(int i=0; i<nums.length; i++) {
           if(numMap.containsKey(target - nums[i])) {
               res[0] = i;
               res[1] = numMap.get(target - nums[i]);
           }
           numMap.put(nums[i], i);
       }
       return res;
    }
}