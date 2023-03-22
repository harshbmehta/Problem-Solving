// The idea is to have two conditions: 
// One in which we will take the element into consideration, 
// Second in which we won't take the element into consideration.
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void helper(int[] nums, List tempList, int start) {
        ans.add(new ArrayList(tempList));
        for(int i=start; i<nums.length; i++) {
            tempList.add(nums[i]);
            helper(nums, tempList, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
