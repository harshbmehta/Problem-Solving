/*
    Time Complexity: O(n^2). twoSumII is O(n), and we call it n times.

    Sorting the array takes O(nlog⁡n), so overall complexity is O(nlog⁡n+n^2). This is asymptotically equivalent to O(n^2).

    Space Complexity: from O(log⁡n) to O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.

*/

class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, res);   
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int L = i+1, R = nums.length-1;
        while (R > L) {
            int sum =  nums[i] + nums[L] + nums[R];

            if (sum > 0) {
                R--;
            } else if (sum < 0){
                L++;
            } else {
                res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                L++;
                R--;
                // ****WHILE LOOP HERE***** to increment L incase there are duplicates
                while (R>L && nums[L-1] == nums[L]) {
                    L++;
                }
            }
        }
    }
}